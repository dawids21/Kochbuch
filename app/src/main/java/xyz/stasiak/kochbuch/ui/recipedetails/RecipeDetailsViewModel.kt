package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.data.RecipeType
import xyz.stasiak.kochbuch.data.RecipeWithIngredientsAndSteps
import xyz.stasiak.kochbuch.data.RecipesRepository

class RecipeDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    recipesRepository: RecipesRepository
) : ViewModel() {
    val recipe: StateFlow<RecipeWithIngredientsAndSteps> =
        recipesRepository.getRecipe(checkNotNull(savedStateHandle[RecipeDetailsDestination.recipeId]))
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = RecipeWithIngredientsAndSteps(
                    recipe = Recipe(
                        id = 0,
                        name = "",
                        type = RecipeType.MAIN_COURSE,
                        image = R.drawable.main_course
                    ),
                    steps = emptyList(),
                    ingredients = emptyList()
                )
            )
}