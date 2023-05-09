package xyz.stasiak.kochbuch.data

import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    fun getAllMainCourses(): Flow<List<RecipeWithIngredientsAndSteps>>
    fun getAllSoups(): Flow<List<RecipeWithIngredientsAndSteps>>
    fun getRecipe(id: Int): Flow<RecipeWithIngredientsAndSteps>
}
