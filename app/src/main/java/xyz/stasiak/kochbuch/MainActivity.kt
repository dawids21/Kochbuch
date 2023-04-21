package xyz.stasiak.kochbuch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.stasiak.kochbuch.ui.theme.KochbuchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KochbuchTheme {
                KochbuchApp()
            }
        }
    }
}