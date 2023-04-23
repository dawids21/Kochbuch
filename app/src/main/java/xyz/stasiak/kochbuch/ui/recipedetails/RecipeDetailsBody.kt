package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.data.RecipeIngredient
import xyz.stasiak.kochbuch.data.RecipeStep

@Composable
fun RecipeDetailsBody(
    recipe: Recipe,
    ingredients: List<RecipeIngredient>,
    steps: List<RecipeStep>,
    timerStates: Map<RecipeStep, TimerUiState>,
    onTimerStart: (RecipeStep) -> Unit,
    onTimerPause: (RecipeStep) -> Unit,
    onTimerStop: (RecipeStep) -> Unit,
    onTimerValueChange: (RecipeStep, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = recipe.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = recipe.name,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h5
        )
        Text(
            text = stringResource(R.string.ingredients),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h6
        )
        ingredients.forEach { ingredient ->
            RecipeIngredientItem(ingredient)
        }
        Text(
            text = stringResource(R.string.steps),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h6
        )
        steps.forEach { step ->
            RecipeStepItem(
                step = step,
                timerState = timerStates[step]!!,
                onTimerStart = { onTimerStart(step) },
                onTimerPause = { onTimerPause(step) },
                onTimerStop = { onTimerStop(step) },
                onTimerValueChange = { onTimerValueChange(step, it) }
            )
        }
    }
}
