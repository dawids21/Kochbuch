package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.stasiak.kochbuch.R

@Composable
fun PortionCounter(
    numberOfPortions: Int,
    onPlusClicked: () -> Unit,
    onMinusClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.portions, numberOfPortions),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h6
        )
        Row {
            IconButton(
                onClick = onPlusClicked
            ) {
                Icon(Icons.Default.Remove, null)
            }
            IconButton(
                onClick = onMinusClicked
            ) {
                Icon(Icons.Default.Add, null)
            }
        }
    }
}