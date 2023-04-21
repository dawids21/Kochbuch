package xyz.stasiak.kochbuch.ui.recipedetails

import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.data.RecipeIngredient
import xyz.stasiak.kochbuch.data.RecipeStep
import xyz.stasiak.kochbuch.data.RecipeType
import xyz.stasiak.kochbuch.data.RecipeWithIngredientsAndSteps

class RecipeDetailsUiState(
    val recipe: Recipe,
    val ingredients: List<RecipeIngredient>,
    val steps: List<RecipeStep>
) {
    constructor(recipeWithIngredientsAndSteps: RecipeWithIngredientsAndSteps) : this(
        recipeWithIngredientsAndSteps.recipe,
        recipeWithIngredientsAndSteps.ingredients,
        recipeWithIngredientsAndSteps.steps
    )

    companion object {
        val EMPTY = RecipeDetailsUiState(
            Recipe(0, "", RecipeType.MAIN_COURSE, R.drawable.main_course),
            emptyList(),
            emptyList()
        )
    }
}