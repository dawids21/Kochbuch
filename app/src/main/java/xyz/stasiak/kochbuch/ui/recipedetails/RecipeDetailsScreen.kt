package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.stasiak.kochbuch.ui.AppViewModelProvider

@Composable
fun RecipeDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Text(text = viewModel.recipeId.toString(), modifier = modifier)
}
