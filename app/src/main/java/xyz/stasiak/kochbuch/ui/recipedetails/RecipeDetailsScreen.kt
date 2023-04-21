package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.stasiak.kochbuch.ui.AppViewModelProvider

@Composable
fun RecipeDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val recipe by viewModel.recipe.collectAsState()
    Text(text = recipe.recipe.name, modifier = modifier)
}
