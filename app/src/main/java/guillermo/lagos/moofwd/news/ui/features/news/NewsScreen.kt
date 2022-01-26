package guillermo.lagos.moofwd.news.ui.features.news

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NewsScreen(
    vm: NewsVm = hiltViewModel(),
    onSelection:(Int) -> Unit,
    onBack:() -> Unit
) {

    LaunchedEffect(Unit){
        if (vm.news.isNullOrEmpty()) vm.getNews()
    }

    BackHandler(enabled = true) {
        onBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "News")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        vm.getNews()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = null
                        )
                    }
                }
            )
        }) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 50.dp
            )
        ){

            if (vm.loading.value) item {
                LoadingView()
            }

            if (vm.error.value) item {
                ErrorView{
                    vm.error.value = false
                }
            }

            if (!vm.loading.value) items(vm.news) {
                NewItemView(
                    info = it,
                    onSelection = onSelection
                )
            }
        }
    }
}

@Composable
fun LoadingView() {
    Card(
        modifier = Modifier.padding(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Updating...",
                fontWeight = FontWeight.Bold
            )

            CircularProgressIndicator(
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun ErrorView(
    onClose: () -> Unit
) {
    Card(
        modifier = Modifier.padding(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "An error has occurred, please try again",
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = onClose) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = null
                )
            }
        }
    }
}