package xyz.stasiak.kochbuch.ui.main.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.stasiak.kochbuch.R

@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
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
        InfoAnimation(350.dp)
    }
}