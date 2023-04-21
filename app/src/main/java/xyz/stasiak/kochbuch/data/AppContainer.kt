package xyz.stasiak.kochbuch.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val recipeRepository: RecipesRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val recipeRepository: RecipesRepository by lazy {
        OfflineRecipesRepository(KochbuchDatabase.getDatabase(context).recipeDao())
    }
}