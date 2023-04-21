package xyz.stasiak.kochbuch.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.data.RecipesRepository

class MainViewModel(recipesRepository: RecipesRepository) : ViewModel() {
    val mainCourses: StateFlow<List<Recipe>> = recipesRepository.getAllMainCourses()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = emptyList()
        )
    val soups: StateFlow<List<Recipe>> = recipesRepository.getAllSoups()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = emptyList()
        )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}