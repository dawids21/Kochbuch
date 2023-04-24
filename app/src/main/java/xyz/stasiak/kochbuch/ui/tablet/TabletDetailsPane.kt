package xyz.stasiak.kochbuch.ui.tablet

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.data.RecipeStep
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsBody
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsUiState
import xyz.stasiak.kochbuch.ui.recipedetails.TimerEvent
import xyz.stasiak.kochbuch.ui.recipedetails.TimerUiState

@Composable
fun TabletDetailsPane(
    recipeDetailsUiState: RecipeDetailsUiState,
    timerStates: SnapshotStateMap<RecipeStep, TimerUiState>,
    onTimerEvent: (TimerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.navigationBarsPadding(),
                contentColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = stringResource(R.string.recipe_details_share),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        // TODO display something when no recipe is selected
        RecipeDetailsBody(
            recipe = recipeDetailsUiState.recipe,
            ingredients = recipeDetailsUiState.ingredients,
            steps = recipeDetailsUiState.steps,
            timerStates = timerStates,
            onTimerEvent = onTimerEvent,
            modifier = Modifier.padding(innerPadding)
        )
    }
}