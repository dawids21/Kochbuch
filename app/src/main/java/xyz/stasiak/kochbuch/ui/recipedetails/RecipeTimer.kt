package xyz.stasiak.kochbuch.ui.recipedetails

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun RecipeTimer(
    timerState: TimerUiState,
    onTimerStart: () -> Unit,
    onTimerPause: () -> Unit,
    onTimerStop: () -> Unit,
    onTimerValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        if (timerState.isRunning) {
            Text(
                text = formatTime(timerState.time),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(end = 8.dp)
            )
        } else {
            TextField(
                value = if (timerState.time != 0) timerState.time.toString() else "",
                onValueChange = { newValue ->
                    try {
                        onTimerValueChange(newValue.toInt())
                    } catch (e: NumberFormatException) {
                        onTimerValueChange(0)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.width(100.dp)
            )
        }
        IconButton(onClick = { onTimerStart() }) {
            Icon(Icons.Filled.PlayArrow, contentDescription = "Start Timer")
        }
        IconButton(onClick = { onTimerPause() }) {
            Icon(Icons.Filled.Pause, contentDescription = "Pause Timer")
        }
        IconButton(onClick = { onTimerStop() }) {
            Icon(Icons.Filled.Stop, contentDescription = "Stop Timer")
        }
    }
}