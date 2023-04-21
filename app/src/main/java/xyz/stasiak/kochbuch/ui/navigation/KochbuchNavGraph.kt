package xyz.stasiak.kochbuch.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import xyz.stasiak.kochbuch.ui.main.MainDestination
import xyz.stasiak.kochbuch.ui.main.MainScreen
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsDestination
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsScreen

@Composable
fun KochbuchNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MainDestination.route,
        modifier = modifier
    ) {
        composable(route = MainDestination.route) {
            MainScreen(navController = rememberNavController(), navigateToRecipe = {
                navController.navigate(
                    "${RecipeDetailsDestination.route}/${it}"
                )
            })
        }
        composable(
            route = RecipeDetailsDestination.routeWithArgs,
            arguments = listOf(
                navArgument(RecipeDetailsDestination.recipeId) {
                    type = NavType.IntType
                }
            )
        ) {
            RecipeDetailsScreen()
        }
    }
}
