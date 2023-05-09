package xyz.stasiak.kochbuch.data

import kotlinx.coroutines.flow.Flow

class OfflineRecipesRepository(private val recipeDao: RecipeDao) : RecipesRepository {
    override fun getAllMainCourses(): Flow<List<RecipeWithIngredientsAndSteps>> {
        return recipeDao.getAllMainCourses()
    }

    override fun getAllSoups(): Flow<List<RecipeWithIngredientsAndSteps>> {
        return recipeDao.getAllSoups()
    }

    override fun getRecipe(id: Int): Flow<RecipeWithIngredientsAndSteps> {
        return recipeDao.getRecipe(id)
    }
}
