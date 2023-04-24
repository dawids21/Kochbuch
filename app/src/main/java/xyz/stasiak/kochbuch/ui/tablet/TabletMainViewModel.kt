package xyz.stasiak.kochbuch.ui.tablet

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.data.RecipeStep
import xyz.stasiak.kochbuch.data.RecipesRepository
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsUiState
import xyz.stasiak.kochbuch.ui.recipedetails.TimerEvent
import xyz.stasiak.kochbuch.ui.recipedetails.TimerUiState
import xyz.stasiak.kochbuch.ui.recipedetails.playSound

class TabletMainViewModel(recipesRepository: RecipesRepository) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

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

    val recipeId = mutableStateOf<Int?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val recipe = snapshotFlow { recipeId.value }
        .filterNotNull()
        .flatMapLatest { recipesRepository.getRecipe(it) }
        .mapLatest { RecipeDetailsUiState(it) }
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
                    timerStates[step] = TimerUiState(time = step.time)
                }
            }
        }
    }

    fun setRecipeId(id: Int) {
        recipeId.value = id
    }

    fun onTimerEvent(event: TimerEvent) {
        when (event) {
            is TimerEvent.StartClicked -> startTimer(event.step)
            is TimerEvent.PauseClicked -> pauseTimer(event.step)
            is TimerEvent.StopClicked -> stopTimer(event.step)
            is TimerEvent.TimeChanged -> setTimerValue(event.step, event.time)
        }
    }

    private fun startTimer(step: RecipeStep) {
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
        timerStates[step] = timerState.copy(time = step.time, isRunning = false)
    }

    private fun setTimerValue(step: RecipeStep, value: Int) {
        timerStates[step] = timerStates[step]!!.copy(time = value)
    }
}