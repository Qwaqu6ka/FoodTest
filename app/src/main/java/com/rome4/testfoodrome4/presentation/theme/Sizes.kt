package com.rome4.testfoodrome4.presentation.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val screenHorizontalPadding: Dp = 16.dp

@Immutable
data class Sizes(
    val toolbar: ToolbarSizes = ToolbarSizes(),
    val errorResultContentArrangement: Dp = 10.dp,
    val menuScreen: MenuScreenSizes = MenuScreenSizes(),
    val button: ButtonSizes = ButtonSizes(),
)

@Immutable
data class ButtonSizes(
    val cornerRadius: Dp = 6.dp,
    val innerPadding: PaddingValues = PaddingValues(8.dp),
    val outlinedButtonBorderWidth: Dp = 1.dp
)

@Immutable
data class ToolbarSizes(
    val contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    val cityArrowArrangement: Dp = 8.dp
)

@Immutable
data class MenuScreenSizes(
    val categoriesPanel: CategoriesPanelSizes = CategoriesPanelSizes(),
    val foodCard: FoodCardSizes = FoodCardSizes(),
    val addBanner: AddBannerSizes = AddBannerSizes()
)

@Immutable
data class CategoriesPanelSizes(
    val categoriesArrangement: Dp = 8.dp,
    val categoriesPadding: PaddingValues = PaddingValues(vertical = 16.dp),
    val startEndSpacer: Dp = screenHorizontalPadding - categoriesArrangement
)

@Immutable
data class AddBannerSizes(
    val itemsArrangement: Dp = 16.dp,
    val bannersPadding: PaddingValues = PaddingValues(
        top = 16.dp,
        bottom = 10.dp,
    ),
    val startEndSpacer: Dp = screenHorizontalPadding - itemsArrangement,
    val bannerHeight: Dp = 112.dp,
    val cornerRadius: Dp = 10.dp,
)

@Immutable
data class FoodCardSizes(
    val contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
    val horizontalArrangement: Dp = 22.dp,
    val verticalArrangement: Dp = 8.dp,
    val cardHeight: Dp = 151.dp,
)