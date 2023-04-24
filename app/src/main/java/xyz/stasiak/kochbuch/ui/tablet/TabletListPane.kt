package xyz.stasiak.kochbuch.ui.tablet

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.ui.main.MainBottomBar
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.info.InfoScreen
import xyz.stasiak.kochbuch.ui.main.recipes.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomSoupDestination
import xyz.stasiak.kochbuch.ui.main.recipes.RecipeScreen

@Composable
fun TabletListPane(
    navController: NavHostController,
    mainCourses: List<Recipe>,
    soups: List<Recipe>,
    navigateToRecipe: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = { MainBottomBar(navController = navController) },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomInfoDestination.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BottomInfoDestination.route) {
                InfoScreen()
            }
            composable(route = BottomSoupDestination.route) {
                RecipeScreen(recipes = soups, navigateToRecipe = navigateToRecipe)
            }
            composable(route = BottomMainCourseDestination.route) {
                RecipeScreen(
                    recipes = mainCourses,
                    navigateToRecipe = navigateToRecipe
                )
            }
        }
    }
}