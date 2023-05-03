package xyz.stasiak.kochbuch.ui.main.info

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun InfoAnimation(size: Dp) {
    val spoonPosition = remember {
        Animatable(0f)
    }
    val eggVisibility = remember {
        Animatable(0f)
    }
    val eggPosition = remember {
        Animatable(0f)
    }
    val eggYolkVisibility = remember {
        Animatable(0f)
    }
    val eggYolkPosition = remember {
        Animatable(0f)
    }
    LaunchedEffect(null) {
        launch {
            spoonPosition.animateTo(
                1f, animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
        launch {
            while (true) {
                eggVisibility.animateTo(
                    1f, animationSpec = tween(1000, easing = LinearEasing)
                )
                eggYolkVisibility.animateTo(
                    1f, animationSpec = snap()
                )
                eggPosition.animateTo(
                    1f, animationSpec = tween(500, easing = FastOutLinearInEasing)
                )
                eggYolkPosition.animateTo(
                    1f, animationSpec = tween(500, easing = FastOutLinearInEasing)
                )
                delay(1000)
                eggVisibility.animateTo(
                    0f, animationSpec = tween(1000, easing = LinearEasing)
                )
                eggPosition.animateTo(
                    0f, animationSpec = snap()
                )
                eggYolkVisibility.animateTo(
                    0f, animationSpec = snap()
                )
                eggYolkPosition.animateTo(
                    0f, animationSpec = snap()
                )
            }
        }
    }
    val color = MaterialTheme.colors.primary
    Canvas(modifier = Modifier.size(size),
        onDraw = {
            val sizePx = size.toPx()
            val xPosition = sizePx / 5 + spoonPosition.value * (sizePx * 3 / 5 - sizePx / 8)
            drawRoundRect(
                color = Color.Gray,
                topLeft = Offset(xPosition, sizePx / 6),
                size = Size(sizePx / 8, sizePx / 2),
                cornerRadius = CornerRadius(16f)
            )
            drawCircle(
                color = Color(0xFFFFD500),
                alpha = eggYolkVisibility.value,
                center = Offset(
                    sizePx * 5 / 8 + sizePx / 12,
                    sizePx / 16 + eggYolkPosition.value * sizePx / 2
                ),
                radius = sizePx / 32
            )
            drawArc(
                color = Color(0xffcf8686),
                alpha = eggVisibility.value,
                startAngle = 90f,
                sweepAngle = -180f,
                useCenter = true,
                topLeft = Offset(sizePx * 5 / 8 + eggPosition.value * sizePx / 16, 0f),
                size = Size(sizePx / 6, sizePx / 8)
            )
            drawArc(
                color = Color(0xffcf8686),
                alpha = eggVisibility.value,
                startAngle = 90f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(sizePx * 5 / 8 - eggPosition.value * sizePx / 16, 0f),
                size = Size(sizePx / 6, sizePx / 8)
            )
            drawArc(
                color = color,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = true,
            )
        }
    )
}

@Preview
@Composable
fun InfoAnimationPreview() {
    InfoAnimation(200.dp)
}