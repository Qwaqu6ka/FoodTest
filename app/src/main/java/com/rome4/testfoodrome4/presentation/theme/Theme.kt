package com.rome4.testfoodrome4.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val typography = Typography()
    val sizes = Sizes()

    CompositionLocalProvider(
        LocalTypography provides typography,
        LocalSizes provides sizes,
        content = content
    )
}

object AppTheme {
    val typography: Typography
        @Composable get() = LocalTypography.current
    val sizes: Sizes
        @Composable get() = LocalSizes.current
}

val LocalTypography = staticCompositionLocalOf<Typography> {
    error("No typography provided")
}

val LocalSizes = staticCompositionLocalOf<Sizes> {
    error("No sizes provided")
}