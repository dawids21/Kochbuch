package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import xyz.stasiak.kochbuch.data.RecipeStep

@Composable
fun RecipeTimer(
    step: RecipeStep,
    timerState: TimerUiState,
    onTimerEvent: (TimerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    if (step.time != 0) {
        val minutes = timerState.time / 60
        val seconds = timerState.time % 60
        Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
            if (timerState.isRunning) {
                Text(
                    text = formatTime(timerState.time),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(end = 8.dp)
                )
            } else {
                //TODO poprawić wielkość, szerokość, wyświetlić dwa pola na minuty i sekundy
                // i dodać logikę przeliczania na sekundy
                Row(horizontalArrangement = Arrangement.End, modifier = modifier) {
                    TextField(
                        value = if (timerState.time != 0) timerState.time.toString() else "",
                        onValueChange = { newValue ->
                            try {
                                onTimerEvent(TimerEvent.TimeChanged(step, newValue.toInt()))
                            } catch (e: NumberFormatException) {
                                onTimerEvent(TimerEvent.TimeChanged(step, 0))
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.width(100.dp)
                    )
                    TextField(
                        value = if (timerState.time != 0) timerState.time.toString() else "",
                        onValueChange = { newValue ->
                            try {
                                onTimerEvent(TimerEvent.TimeChanged(step, newValue.toInt()))
                            } catch (e: NumberFormatException) {
                                onTimerEvent(TimerEvent.TimeChanged(step, 0))
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.width(100.dp)
                    )
                }
            }
            //TODO wystarczy 1 przycisk naraz:
            // nie działa to play
            // działa ale jeszcze liczy to pause
            // skończył liczyć to stop
            Row(modifier = modifier) {
                IconButton(onClick = { onTimerEvent(TimerEvent.StartClicked(step)) }) {
                    Icon(Icons.Filled.PlayArrow, contentDescription = "Start Timer")
                }
                IconButton(onClick = { onTimerEvent(TimerEvent.PauseClicked(step)) }) {
                    Icon(Icons.Filled.Pause, contentDescription = "Pause Timer")
                }
                IconButton(onClick = { onTimerEvent(TimerEvent.StopClicked(step)) }) {
                    Icon(Icons.Filled.Stop, contentDescription = "Stop Timer")
                }
            }
        }
    }
}