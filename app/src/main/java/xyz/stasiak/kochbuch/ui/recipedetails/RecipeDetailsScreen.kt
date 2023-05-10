package xyz.stasiak.kochbuch.ui.recipedetails

import android.content.Intent
import android.media.MediaPlayer
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import xyz.stasiak.kochbuch.R
import xyz.stasiak.kochbuch.ui.AppViewModelProvider

@Composable
fun RecipeDetailsScreen(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RecipeDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val context = LocalContext.current
    val recipeDetailsUiState by viewModel.recipe.collectAsState()
    val timerStates = viewModel.timerStates
    val isSoundPlaying = viewModel.isSoundPlaying
    val mediaPlayer by remember { mutableStateOf(MediaPlayer.create(context, R.raw.ringtone)) }
    val shareDataCreator = ShareDataCreator()
    val ingredientsToShare = shareDataCreator.dataCreator(recipeDetailsUiState)
//        recipeDetailsUiState.ingredients.joinToString(separator = "\n") { it.name }
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
            FloatingActionButton(
                onClick = { context.startActivity(shareIntent) },
                modifier = Modifier.navigationBarsPadding(),
                contentColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = stringResource(R.string.recipe_details_share),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        RecipeDetailsBodyWithAppBar(
            recipe = recipeDetailsUiState.recipe,
            ingredients = recipeDetailsUiState.ingredients,
            steps = recipeDetailsUiState.steps,
            timerStates = timerStates,
            onTimerEvent = viewModel::onTimerEvent,
            navigateUp = navigateUp,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
