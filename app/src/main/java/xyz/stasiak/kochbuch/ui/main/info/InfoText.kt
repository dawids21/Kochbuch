package xyz.stasiak.kochbuch.ui.main.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.stasiak.kochbuch.R

@Composable
fun InfoText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(start = 20.dp)
            .padding(bottom = 5.dp)
    ) {
        Text(
            text = stringResource(R.string.welcome),
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = stringResource(R.string.app_info),
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = stringResource(R.string.functions),
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(text = stringResource(R.string.soup_function))
        Text(text = stringResource(R.string.main_course_function))
        Text(text = stringResource(R.string.shopping_list))
        Text(text = stringResource(R.string.step_list))
        Text(text = stringResource(R.string.timer))
    }
}