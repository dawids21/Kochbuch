package xyz.stasiak.kochbuch.ui.recipedetails

import xyz.stasiak.kochbuch.data.RecipeStep

sealed interface TimerEvent {
    data class StartClicked(val step: RecipeStep) : TimerEvent
    data class PauseClicked(val step: RecipeStep) : TimerEvent
    data class StopClicked(val step: RecipeStep) : TimerEvent
    data class TimeChanged(val step: RecipeStep, val time: Int) : TimerEvent
}