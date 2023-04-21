package xyz.stasiak.kochbuch

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import xyz.stasiak.kochbuch.ui.navigation.KochbuchNavHost

@Composable
fun KochbuchApp(navController: NavHostController = rememberNavController()) {
    KochbuchNavHost(navController = navController)
}
