package xyz.stasiak.kochbuch.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val type: RecipeType,
    @DrawableRes val image: Int,
    // TODO dodać info o kaloryczności (po zmianie modelu trzeba odinstalować i zainstalować aplikacje)
)
