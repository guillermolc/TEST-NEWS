package guillermo.lagos.moofwd.news.ui.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import guillermo.lagos.moofwd.news.ui.features.detail.NewDetailScreen
import guillermo.lagos.moofwd.news.ui.features.news.NewsScreen

@Composable
fun Navigation(
    activity: Activity
) {

    val navController = rememberNavController()

    val actions = remember(navController) {
        Actions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = Destinations.News
    ){

        composable(
            route = Destinations.News
        ) {
            NewsScreen(
                onSelection = actions.openNewDetail,
                onBack = {
                    activity.finish()
                }
            )
        }

        composable(
            route = Destinations.NewDetail.Route,
            arguments = Destinations.NewDetail.Arguments
        ) {

            val parentEntry = remember {
                navController.currentBackStackEntry
            }

            NewDetailScreen(
                newId = parentEntry
                    ?.arguments
                    ?.getInt(Destinations.NewDetail.NewId)
                    ?: 0,
                onBack = actions.navigateBack
            )
        }
    }
}