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
    //TODO change after testing
    if (widthSizeClass == WindowWidthSizeClass.Compact && heightSizeClass == WindowHeightSizeClass.Compact) {
//    if (heightSizeClass != WindowHeightSizeClass.Compact) {
        KochbuchNavHost(layoutType = LayoutType.PHONE, navController = navController)
    } else {
        KochbuchNavHost(layoutType = LayoutType.TABLET, navController = navController)
    }
}
