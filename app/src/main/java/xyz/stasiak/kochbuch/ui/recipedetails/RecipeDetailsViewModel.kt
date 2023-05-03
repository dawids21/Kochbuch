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
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val recipe: StateFlow<RecipeDetailsUiState> =
        recipesRepository.getRecipe(
            savedStateHandle[RecipeDetailsDestination.recipeId] ?: 1
        ) // TODO for testing tablet
            .map { RecipeDetailsUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = RecipeDetailsUiState.EMPTY
            )

    val timerStates = mutableStateMapOf<RecipeStep, TimerUiState>()

    init {
        viewModelScope.launch {
            recipe.collect { recipeDetailsUiState ->
                timerStates.clear()
                recipeDetailsUiState.steps.forEach { step ->
                    timerStates[step] = TimerUiState(minutes = step.time, 0)
                }
            }
        }
    }

    fun onTimerEvent(event: TimerEvent) {
        when (event) {
            is TimerEvent.StartClicked -> startTimer(event.step)
            is TimerEvent.PauseClicked -> pauseTimer(event.step)
            is TimerEvent.StopClicked -> stopTimer(event.step)
            is TimerEvent.TimeChanged -> setTimerValue(event.step, event.minutes, event.seconds)
        }
    }

    private fun startTimer(step: RecipeStep) {
        val timerState = timerStates[step]!!
        if (timerState.isRunning) {
            return
        }
        val job = viewModelScope.launch {
            while (timerStates[step]!!.seconds > 0 || timerStates[step]!!.minutes > 0) {
                delay(1000)
                timerStates[step] = if (timerStates[step]!!.seconds > 0) {
                    timerStates[step]!!.copy(seconds = timerStates[step]!!.seconds - 1)
                } else {
                    timerStates[step]!!.copy(
                        minutes = timerStates[step]!!.minutes - 1,
                        seconds = 59
                    )
                }
            }
            playSound()
        }
        timerStates[step] = timerState.copy(job = job, isRunning = true)
    }

    private fun pauseTimer(step: RecipeStep) {
        val timerState = timerStates[step]!!
        if (!timerState.isRunning) {
            return
        }
        timerState.job?.cancel()
        timerStates[step] = timerState.copy(isRunning = false)
    }

    private fun stopTimer(step: RecipeStep) {
        val timerState = timerStates[step]!!
        if (!timerState.isRunning) {
            return
        }
        timerState.job?.cancel()
        timerStates[step] = timerState.copy(minutes = step.time, seconds = 0, isRunning = false)
    }

    private fun setTimerValue(step: RecipeStep, minutes: Int, seconds: Int) {
        timerStates[step] = timerStates[step]!!.copy(minutes = minutes, seconds = seconds)
    }
}

fun playSound() {
    // TODO: implement sound playing logic here
    // TODO przenieść do osobnego pliku
    // TODO narastający dżwięk
}