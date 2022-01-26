package guillermo.lagos.moofwd.news.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import guillermo.lagos.moofwd.news.ui.navigation.Destinations.News

object Destinations{

    const val News = "news"

    object NewDetail{
        const val NewId = "newId"
        val Route = "$this/{$NewId}"
        val Arguments = listOf(
            navArgument(NewId){
                type = NavType.IntType
            }
        )
    }
}

class Actions(
    nav: NavController
){

    val navigateBack: () -> Unit = {
        nav.popBackStack()
    }

    val openNewDetail: (Int) -> Unit = {
        nav.navigate("${Destinations.NewDetail}/$it")
    }


}