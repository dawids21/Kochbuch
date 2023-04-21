package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import xyz.stasiak.kochbuch.data.RecipesRepository

class RecipeDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    recipesRepository: RecipesRepository
) : ViewModel() {
    val recipeId =
        checkNotNull(savedStateHandle[RecipeDetailsDestination.recipeId])
}