package xyz.stasiak.kochbuch.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.stasiak.kochbuch.ui.main.MainDestination
import xyz.stasiak.kochbuch.ui.main.MainScreen

@Composable
fun KochbuchNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MainDestination.route,
        modifier = modifier
    ) {
        composable(route = MainDestination.route) {
            MainScreen(navController = rememberNavController())
        }
    }
}
