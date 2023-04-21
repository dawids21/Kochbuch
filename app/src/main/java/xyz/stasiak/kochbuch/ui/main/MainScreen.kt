package xyz.stasiak.kochbuch.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.stasiak.kochbuch.ui.AppViewModelProvider
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.info.InfoScreen
import xyz.stasiak.kochbuch.ui.main.recipes.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomSoupDestination
import xyz.stasiak.kochbuch.ui.main.recipes.RecipeScreen

@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val mainCourses by viewModel.mainCourses.collectAsState()
    val soups by viewModel.soups.collectAsState()
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
                RecipeScreen(recipes = soups)
            }
            composable(route = BottomMainCourseDestination.route) {
                RecipeScreen(recipes = mainCourses)
            }
        }
    }
}