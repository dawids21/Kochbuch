package xyz.stasiak.kochbuch.ui.tablet

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.stasiak.kochbuch.LayoutType
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.AppViewModelProvider
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.info.InfoScreen
import xyz.stasiak.kochbuch.ui.main.recipes.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomSoupDestination
import xyz.stasiak.kochbuch.ui.main.recipes.RecipeScreen
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsBody

@Composable
fun TabletMainScreen(
    navController: NavHostController,
    layoutType: LayoutType,
    modifier: Modifier = Modifier,
    viewModel: TabletMainViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val mainCourses by viewModel.mainCourses.collectAsState()
    val soups by viewModel.soups.collectAsState()
    val recipeDetailsUiState by viewModel.recipe.collectAsState()
    val timerStates = viewModel.timerStates
    val ingredientsToShare =
        recipeDetailsUiState.ingredients.joinToString(separator = "\n") { it.name }
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, ingredientsToShare)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            if (recipeDetailsUiState.recipe.id != 0) {
                FloatingActionButton(
                    onClick = {
                        context.startActivity(shareIntent)
                    },
                    modifier = Modifier.navigationBarsPadding(),
                    contentColor = MaterialTheme.colors.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = stringResource(R.string.recipe_details_share),
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }
        },
        modifier = modifier
    ) { innerPadding ->
        Row(modifier = Modifier.padding(innerPadding)) {
            TabletNavRail(navController = navController)
            NavHost(
                navController = navController,
                startDestination = BottomInfoDestination.route,
                modifier = Modifier.weight(1f)
            ) {
                composable(route = BottomInfoDestination.route) {
                    InfoScreen(layoutType = layoutType)
                }
                composable(route = BottomSoupDestination.route) {
                    RecipeScreen(recipes = soups, navigateToRecipe = viewModel::setRecipeId)
                }
                composable(route = BottomMainCourseDestination.route) {
                    RecipeScreen(
                        recipes = mainCourses,
                        navigateToRecipe = viewModel::setRecipeId
                    )
                }
            }

            val scrollState = rememberScrollState()

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {
                RecipeDetailsBody(
                    recipe = recipeDetailsUiState.recipe,
                    ingredients = recipeDetailsUiState.ingredients,
                    steps = recipeDetailsUiState.steps,
                    timerStates = timerStates,
                    onTimerEvent = viewModel::onTimerEvent,
                    modifier = Modifier.weight(1f),
                    scrollState = scrollState
                )
            }
        }
    }
}