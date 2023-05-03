package xyz.stasiak.kochbuch.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import xyz.stasiak.kochbuch.R

@Composable
fun KochbuchTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = { }
) {
    if (canNavigateBack) {
        TopAppBar(
            title = { Text(text = title) },
            modifier = modifier,
            navigationIcon = {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            },
            actions = actions
        )
    } else {
        TopAppBar(title = { Text(text = title) }, modifier = modifier, actions = actions)
    }
}
