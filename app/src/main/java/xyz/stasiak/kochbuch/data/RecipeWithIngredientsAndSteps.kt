package xyz.stasiak.kochbuch.data

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeWithIngredientsAndSteps(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "id",
        entityColumn = "recipeId"
    )
    val steps: List<RecipeStep>,
    @Relation(
        parentColumn = "id",
        entityColumn = "recipeId"
    )
    val ingredients: List<RecipeIngredient>
)