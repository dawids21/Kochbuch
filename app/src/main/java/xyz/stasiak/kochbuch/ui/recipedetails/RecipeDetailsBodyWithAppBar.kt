package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.data.RecipeIngredient
import xyz.stasiak.kochbuch.data.RecipeStep
import xyz.stasiak.kochbuch.ui.KochbuchTopAppBar

@Composable
fun RecipeDetailsBodyWithAppBar(
    recipe: Recipe,
    ingredients: List<RecipeIngredient>,
    steps: List<RecipeStep>,
    timerStates: Map<RecipeStep, TimerUiState>,
    onTimerEvent: (TimerEvent) -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        KochbuchTopAppBar(
            title = stringResource(
                id = RecipeDetailsDestination.titleRes,
                recipe.name
            ),
            canNavigateBack = true,
            navigateUp = navigateUp
        )
        RecipeDetailsBody(
            recipe = recipe,
            ingredients = ingredients,
            steps = steps,
            timerStates = timerStates,
            onTimerEvent = onTimerEvent,
            scrollState = scrollState
        )
    }
}
