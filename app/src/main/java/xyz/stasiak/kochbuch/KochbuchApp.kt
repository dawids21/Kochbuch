package xyz.stasiak.kochbuch

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import xyz.stasiak.kochbuch.ui.navigation.KochbuchNavHost

@Composable
fun KochbuchApp(
    widthSizeClass: WindowWidthSizeClass,
    heightSizeClass: WindowHeightSizeClass,
    navController: NavHostController = rememberNavController()
) {
    val isCompactMedium =
        widthSizeClass == WindowWidthSizeClass.Compact && heightSizeClass >= WindowHeightSizeClass.Medium
    val isMediumCompact =
        widthSizeClass >= WindowWidthSizeClass.Medium && heightSizeClass == WindowHeightSizeClass.Compact

    val layoutType =
        if (isCompactMedium)
            LayoutType.PHONE
        else if (isMediumCompact)
            LayoutType.PHONE_LANDSCAPE
        else
            LayoutType.TABLET
    KochbuchNavHost(
        layoutType = layoutType,
        navController = navController
    )
}
