package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.stasiak.kochbuch.data.RecipeIngredient

@Composable
fun RecipeIngredientItem(ingredient: RecipeIngredient, numberOfPortions: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        val amount = ingredient.amount * numberOfPortions
        Text(
            text = "${ingredient.name} - $amount ${ingredient.unit}",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f)
        )
    }
}