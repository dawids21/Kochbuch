package xyz.stasiak.kochbuch.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_ingredients")
data class RecipeIngredient(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val recipeId: Int,
    val name: String,
    val amount: Float,
    val unit: String
)
