package xyz.stasiak.kochbuch.data

import kotlinx.coroutines.flow.Flow

class OfflineRecipesRepository(private val recipeDao: RecipeDao) : RecipesRepository {
    override fun getAllMainCourses(): Flow<List<Recipe>> {
        return recipeDao.getAllMainCourses()
    }

    override fun getAllSoups(): Flow<List<Recipe>> {
        return recipeDao.getAllSoups()
    }
}