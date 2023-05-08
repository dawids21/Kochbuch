package xyz.stasiak.kochbuch.ui.main.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Column() {
            Text(text = "Witamy w  Kochbuch!")
            Text(text = "Jedyna aplikacja, która pozwoli ci zostać mistrzem kuchni!")
            Text(text = "Funkcje:")
            Text(text = "1. Przepisy na najlepsze zupy świata")
            Text(text = "2. Przepisy na najlepsze dania główne świata")
            Text(text = "3. Lista zakupów")
            Text(text = "4. Lista kroków jak przygotować danie")
            Text(text = "5. Minutnik")
        }
        Spacer(modifier = Modifier.height(4.dp))
        InfoAnimation(300.dp)
    }
}