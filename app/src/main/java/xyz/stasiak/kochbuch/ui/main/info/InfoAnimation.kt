package xyz.stasiak.kochbuch.ui.main.info

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
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
import kotlinx.coroutines.launch

@Composable
fun InfoAnimation(size: Dp) {
    val spoonPosition = remember {
        Animatable(0f)
    }
    LaunchedEffect(spoonPosition) {
        launch {
            spoonPosition.animateTo(
                1f, animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
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