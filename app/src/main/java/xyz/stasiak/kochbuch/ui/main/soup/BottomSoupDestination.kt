package xyz.stasiak.kochbuch.ui.main.soup

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.main.BottomNavigationDestination

object BottomSoupDestination : BottomNavigationDestination {
    override val route: String = "soup"
    override val icon: ImageVector = Icons.Filled.ArrowBack
    override val titleRes: Int = R.string.soup
}