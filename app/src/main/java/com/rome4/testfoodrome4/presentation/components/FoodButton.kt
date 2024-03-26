package com.rome4.testfoodrome4.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import com.rome4.testfoodrome4.presentation.theme.AppTheme
import com.rome4.testfoodrome4.presentation.theme.Grey
import com.rome4.testfoodrome4.presentation.theme.Pink
import com.rome4.testfoodrome4.presentation.theme.PinkLight

@Composable
fun FoodButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                indication = rememberRipple(bounded = true),
                interactionSource = interactionSource,
                role = Role.Button,
            )
            .background(
                color = PinkLight,
                shape = RoundedCornerShape(AppTheme.sizes.button.cornerRadius)
            )
    ) {
        Text(
            text = text,
            style = AppTheme.typography.menu.selectedButton,
            color = Pink,
            modifier = Modifier.padding(AppTheme.sizes.button.innerPadding)
        )
    }
}

@Composable
fun UnselectedFoodButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                indication = rememberRipple(bounded = true),
                interactionSource = interactionSource,
                role = Role.Button,
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(AppTheme.sizes.button.cornerRadius)
            )
    ) {
        Text(
            text = text,
            style = AppTheme.typography.menu.unselectedButton,
            color = Grey,
            modifier = Modifier.padding(AppTheme.sizes.button.innerPadding)
        )
    }
}

@Composable
fun OutlinedFoodButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                indication = rememberRipple(bounded = true),
                interactionSource = interactionSource,
                role = Role.Button,
            )
            .border(
                border = BorderStroke(
                    width = AppTheme.sizes.button.outlinedButtonBorderWidth,
                    color = Pink
                ),
                shape = RoundedCornerShape(AppTheme.sizes.button.cornerRadius)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(AppTheme.sizes.button.cornerRadius)
            )
    ) {
        Text(
            text = text,
            style = AppTheme.typography.menu.unselectedButton,
            color = Pink,
            modifier = Modifier.padding(AppTheme.sizes.button.innerPadding)
        )
    }
}