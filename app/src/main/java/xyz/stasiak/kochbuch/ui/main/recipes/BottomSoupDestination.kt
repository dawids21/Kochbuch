package xyz.stasiak.kochbuch.ui.main.recipes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SoupKitchen
import androidx.compose.ui.graphics.vector.ImageVector
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.main.BottomNavigationDestination

object BottomSoupDestination : BottomNavigationDestination {
    override val route: String = "soup"
    override val icon: ImageVector = Icons.Filled.SoupKitchen
    override val titleRes: Int = R.string.soup
}