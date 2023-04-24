package xyz.stasiak.kochbuch.ui.tablet

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import xyz.stasiak.kochbuch.ui.AppViewModelProvider

@Composable
fun TabletMainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: TabletMainViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val mainCourses by viewModel.mainCourses.collectAsState()
    val soups by viewModel.soups.collectAsState()
    val recipeDetailsUiState by viewModel.recipe.collectAsState()
    val timerStates = viewModel.timerStates
    Row(modifier = modifier) {
        // TODO dodać navigation rail
        // TODO powinniśmy mieć tylko 1 scaffold tutaj, a nie w komponentach niżej
        // TODO app bar
        TabletListPane(
            navController = navController,
            mainCourses = mainCourses,
            soups = soups,
            navigateToRecipe = viewModel::setRecipeId,
            modifier = Modifier.weight(1f)
        )
        TabletDetailsPane(
            recipeDetailsUiState = recipeDetailsUiState,
            timerStates = timerStates,
            onTimerEvent = viewModel::onTimerEvent,
            modifier = Modifier.weight(1f)
        )
    }
}