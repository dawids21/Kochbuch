package xyz.stasiak.kochbuch.ui.recipedetails

import kotlinx.coroutines.Job

data class TimerUiState(val time: Int, val isRunning: Boolean = false, val job: Job? = null)