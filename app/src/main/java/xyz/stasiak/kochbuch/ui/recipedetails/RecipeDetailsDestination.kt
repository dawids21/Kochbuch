package xyz.stasiak.kochbuch.ui.recipedetails

import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.navigation.NavigationDestination

object RecipeDetailsDestination : NavigationDestination {
    override val route = "recipe"
    override val titleRes = R.string.empty
    const val recipeId = "recipeId"
    val routeWithArgs = "$route/{$recipeId}"
}