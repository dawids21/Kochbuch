package xyz.stasiak.kochbuch.ui.tablet

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import xyz.stasiak.kochbuch.ui.main.MainScreen
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsScreen

@Composable
fun TabletMainScreen(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        MainScreen(
            navController = rememberNavController(),
            navigateToRecipe = {/*TODO*/ },
            modifier = Modifier.weight(1f)
        )
        RecipeDetailsScreen(modifier = Modifier.weight(1f))
    }
}