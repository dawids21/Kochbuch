package xyz.stasiak.kochbuch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import xyz.stasiak.kochbuch.ui.theme.KochbuchTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KochbuchTheme {
                val windowSize = calculateWindowSizeClass(this)
                KochbuchApp(
                    widthSizeClass = windowSize.widthSizeClass,
                    heightSizeClass = windowSize.heightSizeClass
                )
            }
        }
    }
}