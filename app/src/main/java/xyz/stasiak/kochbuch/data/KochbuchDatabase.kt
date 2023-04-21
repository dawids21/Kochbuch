package xyz.stasiak.kochbuch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Recipe::class, RecipeStep::class, RecipeIngredient::class],
    version = 1,
    exportSchema = false
)
abstract class KochbuchDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var Instance: KochbuchDatabase? = null

        fun getDatabase(context: Context): KochbuchDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, KochbuchDatabase::class.java, "recipe_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            for (recipeWithSteps in RecipesSource.recipes) {
                                db.execSQL(
                                    "INSERT INTO recipes (id, name, type, image) VALUES (${recipeWithSteps.recipe.id}, '${recipeWithSteps.recipe.name}', '${recipeWithSteps.recipe.type}', ${recipeWithSteps.recipe.image})"
                                )
                                for (step in recipeWithSteps.steps) {
                                    db.execSQL(
                                        "INSERT INTO recipe_steps (recipeId, `order`, description, time) VALUES (${step.recipeId}, ${step.order}, '${step.description}', ${step.time})"
                                    )
                                }
                                for (ingredient in recipeWithSteps.ingredients) {
                                    db.execSQL(
                                        "INSERT INTO recipe_ingredients (recipeId, name, amount, unit) VALUES (${ingredient.recipeId}, '${ingredient.name}', ${ingredient.amount}, '${ingredient.unit}')"
                                    )
                                }
                            }
                        }
                    })
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
