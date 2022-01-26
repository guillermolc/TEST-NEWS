package guillermo.lagos.moofwd.news.ui.features.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import guillermo.lagos.moofwd.news.R

@Composable
fun NewDetailScreen(
    vm: NewDetailVm = hiltViewModel(),
    newId: Int,
    onBack: () -> Unit
) {

    LaunchedEffect(Unit){
        vm.getNewById(newId)
    }

    BackHandler(enabled = true) {
        onBack()
    }

    val image = if (
        vm.new.value != null
        &&
        !vm.new.value!!.pictureUrl.isNullOrEmpty()
    ) rememberImagePainter(vm.new.value?.pictureUrl!!)
    else painterResource(id = R.drawable.ic_cancel)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "News detail")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
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
            item {
                Column(
                    modifier = Modifier.padding(
                        top = 8.dp,
                        start = 8.dp,
                        end = 8.dp
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth()
                            .height(200.dp),
                        painter = image,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = vm.new.value?.date ?: "No available",
                        textAlign = TextAlign.Start,
                        fontSize = 12.sp
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = vm.new.value?.title  ?: "No available",
                        textAlign = TextAlign.Start,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = vm.new.value?.description ?: "No available",
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}