package xyz.stasiak.kochbuch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Recipe::class], version = 3, exportSchema = false)
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
                            for (recipe in RecipesSource.recipes) {
                                db.execSQL(
                                    "INSERT INTO recipes (id, name, type, image) VALUES (${recipe.id}, '${recipe.name}', '${recipe.type}', ${recipe.image})"
                                )
                            }
                        }
                    })
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
