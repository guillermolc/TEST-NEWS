package guillermo.lagos.moofwd.news.ui.features.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
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
import coil.compose.rememberImagePainter
import guillermo.lagos.moofwd.domain.New
import guillermo.lagos.moofwd.news.R

@Composable
fun NewItemView(
    info: New,
    onSelection:(Int) -> Unit
) {

    val image = if (!info.pictureUrl.isNullOrEmpty()) rememberImagePainter(info.pictureUrl!!)
    else painterResource(id = R.drawable.ic_cancel)

    Card(
        modifier = Modifier.padding(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp
        )
    ){
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Image(
                modifier = Modifier.size(
                    width = 120.dp,
                    height = 100.dp
                ),
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = info.title  ?: "No available",
                    textAlign = TextAlign.Start,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = info.description ?: "No available",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    text = info.date ?: "No available",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp
                )
            }

            IconButton(
                onClick = {
                    onSelection(info.id)
                }
            ) {
                Icon(
                    modifier = Modifier.size(55.dp),
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }
}
