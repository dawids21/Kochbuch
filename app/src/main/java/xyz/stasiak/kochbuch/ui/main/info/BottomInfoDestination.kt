package xyz.stasiak.kochbuch.ui.main.info

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.main.BottomNavigationDestination

object BottomInfoDestination : BottomNavigationDestination {
    override val route: String = "info"
    override val icon: ImageVector = Icons.Filled.Info
    override val titleRes: Int = R.string.info
}