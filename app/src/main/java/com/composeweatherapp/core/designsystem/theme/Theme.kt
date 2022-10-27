package com.composeweatherapp.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Black,
    primaryVariant = Purple700,
    secondary = TransparentDarkBlue,
    onSurface = WhiteTransparent,
    onSecondary = HighTransparentDarkBlue,
    secondaryVariant = LightBlue,
    error = ErrorRed
)

private val LightColorPalette = lightColors(
    primary = Black,
    primaryVariant = Purple700,
    secondary = TransparentDarkBlue,
    onSurface = WhiteTransparent,
    onSecondary = HighTransparentDarkBlue,
    secondaryVariant = LightBlue,
    error = ErrorRed
)

@Composable
fun ComposeWeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
