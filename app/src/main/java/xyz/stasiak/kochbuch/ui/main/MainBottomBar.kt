package xyz.stasiak.kochbuch.ui.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomSoupDestination

@Composable
fun MainBottomBar(navController: NavController) {
    val items = listOf(
        BottomInfoDestination, BottomSoupDestination, BottomMainCourseDestination
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = stringResource(id = item.titleRes)) },
                label = {
                    Text(
                        text = stringResource(id = item.titleRes),
                    )
                },
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onPrimary.copy(alpha = 0.5f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}