package xyz.stasiak.kochbuch.ui.tablet

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomSoupDestination

@Composable
fun TabletNavRail(navController: NavController, modifier: Modifier = Modifier) {
    val items = listOf(
        BottomInfoDestination, BottomSoupDestination, BottomMainCourseDestination
    )
    NavigationRail(modifier = modifier.fillMaxHeight()) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationRailItem(
                icon = { Icon(item.icon, contentDescription = stringResource(id = item.titleRes)) },
                label = {
                    Text(
                        text = stringResource(id = item.titleRes),
                    )
                },
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