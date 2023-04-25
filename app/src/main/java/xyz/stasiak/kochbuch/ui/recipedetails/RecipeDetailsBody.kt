package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    onTimerEvent: (TimerEvent) -> Unit,
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
        var numberOfPortions by remember { mutableStateOf(1) }
        Text(
            text = stringResource(R.string.portions, numberOfPortions),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h6
        )
        Row(){
            IconButton(
                onClick = {
                    if (numberOfPortions > 1)
                        numberOfPortions--
                }
            ) {
                Icon(Icons.Default.Remove, null)
            }
            IconButton(
                onClick = {
                    if (numberOfPortions < 10)
                    numberOfPortions++
                }
            ) {
                Icon(Icons.Default.Add, null)
            }
        }
        Text(
            text = stringResource(R.string.ingredients),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h6
        )
        ingredients.forEach { ingredient ->
            RecipeIngredientItem(ingredient, numberOfPortions = numberOfPortions)
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
                onTimerEvent = onTimerEvent,
            )
        }
    }
}
