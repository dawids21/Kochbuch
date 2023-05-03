package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import xyz.stasiak.kochbuch.R

@Composable
fun RecipeStepTime(time: Int, modifier: Modifier = Modifier) {
    if(time != 0) {
        Text(
            text = stringResource(R.string.step_time, formatTime(time = time)),
            style = MaterialTheme.typography.caption,
            modifier = modifier
        )
    }
}

@Composable
fun formatTime(time: Int): String {
    val minutes = time / 60
    val seconds = time % 60
    return stringResource(R.string.time_format, minutes, seconds)
}