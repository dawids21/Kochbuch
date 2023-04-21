package xyz.stasiak.kochbuch.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.info.InfoScreen
import xyz.stasiak.kochbuch.ui.main.maincourse.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.maincourse.MainCourseScreen
import xyz.stasiak.kochbuch.ui.main.soup.BottomSoupDestination
import xyz.stasiak.kochbuch.ui.main.soup.SoupScreen

@Composable
fun MainScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { MainBottomBar(navController = navController) },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomInfoDestination.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BottomInfoDestination.route) {
                InfoScreen()
            }
            composable(route = BottomSoupDestination.route) {
                SoupScreen()
            }
            composable(route = BottomMainCourseDestination.route) {
                MainCourseScreen()
            }
        }
    }
}