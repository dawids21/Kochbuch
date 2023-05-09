package xyz.stasiak.kochbuch.ui.recipedetails

import android.content.Intent
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.AppViewModelProvider

@Composable
fun RecipeDetailsScreen(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RecipeDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val recipeDetailsUiState by viewModel.recipe.collectAsState()
    val timerStates = viewModel.timerStates
    val shareDataCreator = ShareDataCreator()
    val ingredientsToShare = shareDataCreator.dataCreator(recipeDetailsUiState)
//        recipeDetailsUiState.ingredients.joinToString(separator = "\n") { it.name }
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, ingredientsToShare)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { context.startActivity(shareIntent) },
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
        RecipeDetailsBodyWithAppBar(
            recipe = recipeDetailsUiState.recipe,
            ingredients = recipeDetailsUiState.ingredients,
            steps = recipeDetailsUiState.steps,
            timerStates = timerStates,
            onTimerEvent = viewModel::onTimerEvent,
            navigateUp = navigateUp,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
