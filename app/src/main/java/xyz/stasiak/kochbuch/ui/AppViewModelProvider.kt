package xyz.stasiak.kochbuch.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import xyz.stasiak.kochbuch.KochbuchApplication
import xyz.stasiak.kochbuch.ui.main.MainViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            MainViewModel(kochbuchApplication().container.recipeRepository)
        }
    }
}

fun CreationExtras.kochbuchApplication(): KochbuchApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as KochbuchApplication)
