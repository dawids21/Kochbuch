package xyz.stasiak.kochbuch.ui.main.recipes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.graphics.vector.ImageVector
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.main.BottomNavigationDestination

object BottomMainCourseDestination : BottomNavigationDestination {
    override val route: String = "maincourse"
    override val icon: ImageVector = Icons.Filled.ArrowForward
    override val titleRes: Int = R.string.main_course
}