package xyz.stasiak.kochbuch.data

import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    fun getAllMainCourses(): Flow<List<Recipe>>
    fun getAllSoups(): Flow<List<Recipe>>
    fun getRecipe(id: Int): Flow<RecipeWithIngredientsAndSteps>
}
