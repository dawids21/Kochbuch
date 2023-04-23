package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import xyz.stasiak.kochbuch.data.RecipeStep
import xyz.stasiak.kochbuch.data.RecipesRepository

class RecipeDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    recipesRepository: RecipesRepository
) : ViewModel() {
    val recipe: StateFlow<RecipeDetailsUiState> =
        recipesRepository.getRecipe(checkNotNull(savedStateHandle[RecipeDetailsDestination.recipeId]))
            .map { RecipeDetailsUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = RecipeDetailsUiState.EMPTY
            )

    val timerStates = mutableStateMapOf<RecipeStep, TimerUiState>()

    init {
        viewModelScope.launch {
            recipe.collect { recipeDetailsUiState ->
                timerStates.clear()
                recipeDetailsUiState.steps.forEach { step ->
                    timerStates[step] = TimerUiState(time = step.time)
                }
            }
        }
    }

    fun startTimer(step: RecipeStep) {
        val timerState = timerStates[step]!!
        if (timerState.isRunning) {
            return
        }
        val job = viewModelScope.launch {
            while (timerStates[step]!!.time > 0) {
                delay(1000)
                timerStates[step] = timerStates[step]!!.copy(time = timerStates[step]!!.time - 1)
            }
            playSound()
        }
        timerStates[step] = timerState.copy(job = job, isRunning = true)
    }

    fun pauseTimer(step: RecipeStep) {
        val timerState = timerStates[step]!!
        if (!timerState.isRunning) {
            return
        }
        timerState.job?.cancel()
        timerStates[step] = timerState.copy(isRunning = false)
    }

    fun stopTimer(step: RecipeStep) {
        val timerState = timerStates[step]!!
        if (!timerState.isRunning) {
            return
        }
        timerState.job?.cancel()
        timerStates[step] = timerState.copy(time = step.time, isRunning = false)
    }

    fun setTimerValue(step: RecipeStep, value: Int) {
        timerStates[step] = timerStates[step]!!.copy(time = value)
    }
}

fun playSound() {
    // TODO: implement sound playing logic here
}