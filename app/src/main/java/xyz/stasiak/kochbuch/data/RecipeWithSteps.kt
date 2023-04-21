package xyz.stasiak.kochbuch.data

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeWithSteps(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "id",
        entityColumn = "recipeId"
    )
    val steps: List<RecipeStep>
)