package com.rome4.testfoodrome4.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rome4.testfoodrome4.R

val sfUiDisplayFamily = FontFamily(
    Font(resId = R.font.sf_ui_display_400, weight = FontWeight.W400)
)

@Immutable
data class Typography(
    val menu: MenuType = MenuType()
)

@Immutable
data class MenuType(
    val toolbarCity: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 18.75.sp
    ),
    val selectedButton: TextStyle = TextStyle(
        fontFamily = sfUiDisplayFamily,
        fontWeight = FontWeight.W400,
        fontSize = 13.sp,
        lineHeight = 15.51.sp,
    ),
    val unselectedButton: TextStyle = TextStyle(
        fontFamily = sfUiDisplayFamily,
        fontWeight = FontWeight.W600,
        fontSize = 13.sp,
        lineHeight = 15.51.sp,
    ),
    val foodCard: FoodCard = FoodCard()
)

@Immutable
data class FoodCard(
    val title: TextStyle = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        lineHeight = 18.75.sp
    ),
    val description: TextStyle = TextStyle(
        fontFamily = sfUiDisplayFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 16.71.sp
    )
)