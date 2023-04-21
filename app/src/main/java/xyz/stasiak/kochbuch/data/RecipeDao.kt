package xyz.stasiak.kochbuch.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes WHERE type = 'MAIN_COURSE'")
    fun getAllMainCourses(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE type = 'SOUP'")
    fun getAllSoups(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE id = :id")
    fun getRecipe(id: Int): Flow<RecipeWithIngredientsAndSteps>
}