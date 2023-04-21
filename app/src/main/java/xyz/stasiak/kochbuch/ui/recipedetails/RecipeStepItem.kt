package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.data.RecipeStep

@Composable
fun RecipeStepItem(step: RecipeStep, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = stringResource(R.string.step_number, step.order),
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = step.description,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 4.dp)
        )
        RecipeStepTime(
            time = step.time,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
