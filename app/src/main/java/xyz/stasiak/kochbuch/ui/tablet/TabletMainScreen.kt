package xyz.stasiak.kochbuch.ui.tablet

import android.content.Intent
import android.media.MediaPlayer
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import xyz.stasiak.kochbuch.LayoutType
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.AppViewModelProvider
import xyz.stasiak.kochbuch.ui.main.info.BottomInfoDestination
import xyz.stasiak.kochbuch.ui.main.info.InfoScreen
import xyz.stasiak.kochbuch.ui.main.recipes.BottomMainCourseDestination
import xyz.stasiak.kochbuch.ui.main.recipes.BottomSoupDestination
import xyz.stasiak.kochbuch.ui.main.recipes.RecipeScreen
import xyz.stasiak.kochbuch.ui.recipedetails.RecipeDetailsBody
import xyz.stasiak.kochbuch.ui.recipedetails.ShareDataCreator

@Composable
fun TabletMainScreen(
    navController: NavHostController,
    layoutType: LayoutType,
    modifier: Modifier = Modifier,
    viewModel: TabletMainViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val context = LocalContext.current
    val mainCourses by viewModel.mainCourses.collectAsState()
    val soups by viewModel.soups.collectAsState()
    val recipeDetailsUiState by viewModel.recipe.collectAsState()
    val timerStates = viewModel.timerStates
    val isSoundPlaying = viewModel.isSoundPlaying
    val mediaPlayer by remember { mutableStateOf(MediaPlayer.create(context, R.raw.ringtone)) }
    val shareDataCreator = ShareDataCreator()
    val ingredientsToShare = shareDataCreator.dataCreator(recipeDetailsUiState)
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, ingredientsToShare)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    val volume = remember {
        Animatable(0f)
    }
    LaunchedEffect(isSoundPlaying) {
        if (isSoundPlaying) {
            launch {
                volume.animateTo(
                    1f, animationSpec = tween(15000, easing = LinearEasing)
                )
            }
        }
    }
    mediaPlayer.setVolume(volume.value, volume.value)
    if (isSoundPlaying) {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.isLooping = true
            mediaPlayer.seekTo(0)
            mediaPlayer.start()
        }
    } else {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
            println("release")
        }
    }
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
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {
                if (recipeDetailsUiState.recipe.id != 0) {
                    Image(
                        painter = painterResource(id = recipeDetailsUiState.recipe.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    bottomStart = 16.dp,
                                    bottomEnd = 16.dp
                                )
                            )
                    )
                }
                RecipeDetailsBody(
                    recipe = recipeDetailsUiState.recipe,
                    ingredients = recipeDetailsUiState.ingredients,
                    steps = recipeDetailsUiState.steps,
                    timerStates = timerStates,
                    onTimerEvent = viewModel::onTimerEvent,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}