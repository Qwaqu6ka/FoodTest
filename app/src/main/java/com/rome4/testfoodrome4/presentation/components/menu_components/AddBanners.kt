package com.rome4.testfoodrome4.presentation.components.menu_components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.rome4.testfoodrome4.R
import com.rome4.testfoodrome4.presentation.theme.AppTheme

@Composable
fun AddBanners(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(AppTheme.sizes.menuScreen.addBanner.bannersPadding),
            horizontalArrangement = Arrangement.spacedBy(AppTheme.sizes.menuScreen.addBanner.itemsArrangement)
        ) {
            Spacer(modifier = Modifier.width(AppTheme.sizes.menuScreen.addBanner.startEndSpacer))
            AsyncImage(
                model = R.drawable.add_banner1,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppTheme.sizes.menuScreen.addBanner.cornerRadius))
                    .fillMaxHeight()
            )
            AsyncImage(
                model = R.drawable.add_banner2,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppTheme.sizes.menuScreen.addBanner.cornerRadius))
                    .fillMaxHeight()
            )
            AsyncImage(
                model = R.drawable.add_banner3,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppTheme.sizes.menuScreen.addBanner.cornerRadius))
                    .fillMaxHeight()
            )
            AsyncImage(
                model = R.drawable.add_banner4,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppTheme.sizes.menuScreen.addBanner.cornerRadius))
                    .fillMaxHeight()
            )
            AsyncImage(
                model = R.drawable.add_banner5,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppTheme.sizes.menuScreen.addBanner.cornerRadius))
                    .fillMaxHeight()
            )
            AsyncImage(
                model = R.drawable.add_banner6,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppTheme.sizes.menuScreen.addBanner.cornerRadius))
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(AppTheme.sizes.menuScreen.addBanner.startEndSpacer))
        }
    }
}