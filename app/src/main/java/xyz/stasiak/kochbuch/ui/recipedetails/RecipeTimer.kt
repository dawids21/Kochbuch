package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.stasiak.kochbuch.data.RecipeStep

@Composable
fun RecipeTimer(
    step: RecipeStep,
    timerState: TimerUiState,
    onTimerEvent: (TimerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    var minutesInput by rememberSaveable { mutableStateOf(timerState.minutes.toString()) }
    var secondsInput by rememberSaveable { mutableStateOf(timerState.seconds.toString()) }
    if (step.time != 0) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(8.dp)
        ) {
            if (timerState.isRunning) {
                Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
                    Text(
                        text = formatTime(timerState.minutes * 60 + timerState.seconds),
                        style = MaterialTheme.typography.body1,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 10.dp)
                            .height(30.dp)
                            .width(160.dp),
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                ) {
                    TextField(
                        value = minutesInput,
                        onValueChange = { newValue ->
                            onTimerEvent(
                                TimerEvent.TimeChanged(
                                    step,
                                    newValue.toIntOrNull() ?: 0,
                                    timerState.seconds
                                )
                            )
                            minutesInput = newValue
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .width(80.dp)
                            .height(60.dp),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        ),
                        visualTransformation = TimeVisualTransformation()
                    )
                    Text(text = ":", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 8.dp))
                    TextField(
                        value = secondsInput,
                        onValueChange = { newValue ->
                            onTimerEvent(
                                TimerEvent.TimeChanged(
                                    step,
                                    timerState.minutes,
                                    newValue.toIntOrNull() ?: 0
                                )
                            )
                            secondsInput = newValue
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .width(80.dp)
                            .height(60.dp),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        ),
                        visualTransformation = TimeVisualTransformation()
                    )
                }
            }
            Row(modifier = modifier) {
                if (!timerState.isRunning) {
                    IconButton(onClick = { onTimerEvent(TimerEvent.StartClicked(step)) }) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = "Start Timer")
                    }
                } else if (timerState.isRunning && (timerState.minutes != 0 || timerState.seconds != 0)) {
                    IconButton(onClick = {
                        onTimerEvent(TimerEvent.PauseClicked(step))
                        minutesInput = timerState.minutes.toString()
                        secondsInput = timerState.seconds.toString()
                    }) {
                        Icon(Icons.Filled.Pause, contentDescription = "Pause Timer")
                    }
                } else {
                    IconButton(onClick = {
                        onTimerEvent(TimerEvent.StopClicked(step))
                        minutesInput = step.time.toString()
                        secondsInput = ""
                    }) {
                        Icon(Icons.Filled.Stop, contentDescription = "Stop Timer")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeTimerPreview() {
    RecipeTimer(
        step = RecipeStep(1, 1, "", 12),
        timerState = TimerUiState(12, 34, false),
        onTimerEvent = {}
    )
}