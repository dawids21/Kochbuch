package xyz.stasiak.kochbuch.ui.recipedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import xyz.stasiak.kochbuch.data.Recipe
import xyz.stasiak.kochbuch.data.RecipeIngredient
import xyz.stasiak.kochbuch.data.RecipeStep
import xyz.stasiak.kochbuch.ui.KochbuchTopAppBar

@Composable
fun RecipeDetailsBodyWithAppBar(
    recipe: Recipe,
    ingredients: List<RecipeIngredient>,
    steps: List<RecipeStep>,
    timerStates: Map<RecipeStep, TimerUiState>,
    onTimerEvent: (TimerEvent) -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val localDensity = LocalDensity.current
    var appBarHeightDp by remember {
        mutableStateOf(0.dp)
    }
    val state = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = modifier.fillMaxSize(),
        state = state,
        scrollStrategy = ScrollStrategy.EnterAlwaysCollapsed,
        toolbar = {
            KochbuchTopAppBar(
                title = stringResource(
                    id = RecipeDetailsDestination.titleRes,
                    recipe.name
                ),
                canNavigateBack = true,
                navigateUp = navigateUp,
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        appBarHeightDp =
                            with(localDensity) { (coordinates.size.height * state.toolbarState.progress).toDp() }
                    }
            )
            Image(
                painter = painterResource(id = recipe.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .parallax(0.5f)
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(top = appBarHeightDp)
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .graphicsLayer {
                        alpha = state.toolbarState.progress
                    },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            RecipeDetailsBody(
                recipe = recipe,
                ingredients = ingredients,
                steps = steps,
                timerStates = timerStates,
                onTimerEvent = onTimerEvent,
            )
        }
    }
}
