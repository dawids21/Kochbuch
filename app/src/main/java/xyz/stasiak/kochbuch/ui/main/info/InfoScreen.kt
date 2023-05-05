package xyz.stasiak.kochbuch.ui.main.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import xyz.stasiak.kochbuch.LayoutType

@Composable
fun InfoScreen(layoutType: LayoutType, modifier: Modifier = Modifier) {
    if (layoutType == LayoutType.PHONE_LANDSCAPE) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxSize()
        ) {
            Text(text = "Info", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                InfoAnimation(200.dp)
            }
        }
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Text(text = "Info")
            Spacer(modifier = Modifier.height(64.dp))
            InfoAnimation(300.dp)
        }
    }
}