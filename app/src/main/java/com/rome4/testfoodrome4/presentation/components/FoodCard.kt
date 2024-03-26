package com.rome4.testfoodrome4.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import com.rome4.testfoodrome4.R
import com.rome4.testfoodrome4.presentation.models.UiFoodItem
import com.rome4.testfoodrome4.presentation.theme.AppTheme
import com.rome4.testfoodrome4.presentation.theme.GreyDark

@Composable
fun FoodCard(item: UiFoodItem, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(AppTheme.sizes.menuScreen.foodCard.contentPadding),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.sizes.menuScreen.foodCard.horizontalArrangement)
    ) {
        AsyncImage(
            model = item.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(4f)
                .clip(CircleShape)
                .fillMaxSize()

        )
        Column(
            verticalArrangement = Arrangement.spacedBy(AppTheme.sizes.menuScreen.foodCard.verticalArrangement),
            modifier = Modifier.weight(6f)
        ) {
            Text(
                text = item.title,
                style = AppTheme.typography.menu.foodCard.title,
                color = Color.Black
            )
            Text(
                text = item.description,
                style = AppTheme.typography.menu.foodCard.description,
                color = GreyDark,
                overflow = TextOverflow.Ellipsis
            )
            OutlinedFoodButton(
                text = stringResource(R.string.price, item.price),
                onClick = {},
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}