package xyz.stasiak.kochbuch.ui.main

import androidx.compose.ui.graphics.vector.ImageVector

interface BottomNavigationDestination {
    val route: String
    val icon: ImageVector
    val titleRes: Int
}