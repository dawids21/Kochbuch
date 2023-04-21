package xyz.stasiak.kochbuch.data

import androidx.room.Entity

@Entity(
    tableName = "recipe_steps",
    primaryKeys = ["recipeId", "order"]
)
data class RecipeStep(
    val recipeId: Int,
    val order: Int,
    val description: String,
    val time: Int
)
