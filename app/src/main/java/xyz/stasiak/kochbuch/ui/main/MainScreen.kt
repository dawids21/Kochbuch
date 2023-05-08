package xyz.stasiak.kochbuch.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import xyz.stasiak.kochbuch.ui.AppViewModelProvider
import xyz.stasiak.kochbuch.ui.KochbuchTopAppBar
import xyz.stasiak.kochbuch.ui.SearchTopAppBar
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.info.InfoScreen
import xyz.stasiak.kochbuch.ui.main.recipes.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomSoupDestination
import xyz.stasiak.kochbuch.ui.main.recipes.RecipeScreen

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    navigateToRecipe: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val mainCourses by viewModel.mainCourses.collectAsState()
    val soups by viewModel.soups.collectAsState()

    var isSearching by remember { mutableStateOf(false) }
    var searchValue by remember { mutableStateOf("") }

    val filteredMainCourses = mainCourses.filter { recipeWithIngredients ->
        recipeWithIngredients.ingredients.any {
            it.name.lowercase().contains(
                searchValue.lowercase()
            )
        }
    }
    val filteredSoups = soups.filter { recipeWithIngredients ->
        recipeWithIngredients.ingredients.any {
            it.name.lowercase().contains(
                searchValue.lowercase()
            )
        }
    }

    val swipeableState = rememberSwipeableState(initialValue = 0)
    val sizePx = with(LocalDensity.current) { 200.dp.toPx() }
    val anchors = mapOf(-sizePx to 1, 0f to 0, sizePx to -1)
    val destinations = listOf(
        BottomInfoDestination, BottomSoupDestination, BottomMainCourseDestination
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = destinations.find { it.route == currentRoute }
    LaunchedEffect(swipeableState.currentValue) {
        if (swipeableState.currentValue == 0) {
            return@LaunchedEffect
        }
        currentDestination?.let { destination ->
            val index = destinations.indexOf(destination)
            val nextIndex = index + swipeableState.currentValue
            if (nextIndex in destinations.indices) {
                navController.navigate(destinations[nextIndex].route) {
                    navController.graph.startDestinationRoute?.let { screenRoute ->
                        popUpTo(screenRoute) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
            swipeableState.snapTo(0)
        }
    }
    Scaffold(
        topBar = {
            if (isSearching) {
                SearchTopAppBar(
                    value = searchValue,
                    onValueChange = { searchValue = it },
                    onBackClicked = {
                        isSearching = false
                        searchValue = ""
                    })
            } else {
                KochbuchTopAppBar(
                    title = currentDestination?.let { stringResource(id = it.titleRes) } ?: "",
                    canNavigateBack = false,
                    actions = {
                        if (currentDestination != BottomInfoDestination) {
                            IconButton(onClick = { isSearching = true }) {
                                Icon(
                                    Icons.Filled.Search,
                                    contentDescription = "Search for recipe with given ingredient"
                                )
                            }
                        }
                    }
                )
            }
        },
        bottomBar = {
            MainBottomBar(navController = navController, beforeNavigation = {
                isSearching = false
                searchValue = ""
            })
        },
        modifier = modifier.swipeable(
            state = swipeableState,
            anchors = anchors,
            thresholds = { _, _ -> FractionalThreshold(0.5f) },
            orientation = Orientation.Horizontal
        )
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
                RecipeScreen(
                    recipes = filteredSoups.map { it.recipe },
                    navigateToRecipe = navigateToRecipe
                )
            }
            composable(route = BottomMainCourseDestination.route) {
                RecipeScreen(
                    recipes = filteredMainCourses.map { it.recipe },
                    navigateToRecipe = navigateToRecipe
                )
            }
        }
    }
}