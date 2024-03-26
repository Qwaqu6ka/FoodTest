package com.rome4.testfoodrome4.presentation.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.rome4.testfoodrome4.presentation.components.FoodCard
import com.rome4.testfoodrome4.presentation.components.Toolbar
import com.rome4.testfoodrome4.presentation.components.menu_components.AddBanners
import com.rome4.testfoodrome4.presentation.components.menu_components.CategoryPanel
import com.rome4.testfoodrome4.presentation.result_api.Result
import com.rome4.testfoodrome4.presentation.result_api.SimpleResultRenderer
import com.rome4.testfoodrome4.presentation.theme.AppTheme
import com.rome4.testfoodrome4.presentation.theme.Grey
import com.rome4.testfoodrome4.presentation.theme.GreyLight
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(modifier: Modifier = Modifier, viewModel: MenuViewModel = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier,
        containerColor = GreyLight,
        topBar = {
            Toolbar(
                cities = state.cities,
                activeCity = state.activeCity,
                onActiveCityChange = viewModel::changeActiveCity,
                onScanQrCode = {},
                dropdownEnabled = state.finalResult is Result.SuccessResult
            )
        }
    ) { scaffoldPadding ->
        SimpleResultRenderer(
            result = state.finalResult,
            onTryAgain = viewModel::reloadData,
            modifier = modifier
                .fillMaxSize()
                .padding(scaffoldPadding)
        ) {
            val density = LocalDensity.current
            val realBannersHeight =
                AppTheme.sizes.menuScreen.addBanner.bannerHeight +
                        AppTheme.sizes.menuScreen.addBanner.bannersPadding.calculateTopPadding() +
                        AppTheme.sizes.menuScreen.addBanner.bannersPadding.calculateBottomPadding()

            var currentBannersHeightPixels by remember {
                with(density) {
                    mutableFloatStateOf(realBannersHeight.toPx())
                }
            }
            val animatedBannersHeight by animateDpAsState(
                targetValue = with(density) {
                    currentBannersHeightPixels.toDp()
                }, label = "Banners height dp"
            )
            val listScrollState = rememberLazyListState()
            val nestedScrollConnection = rememberNestedScrollConnection(
                onBannerHeightChange = { currentBannersHeightPixels = it },
                appBarHeightPx = with(density) { realBannersHeight.toPx() },
                listCanScrollBackwards = { listScrollState.canScrollBackward }
            )
            Column(modifier = Modifier.nestedScroll(nestedScrollConnection)) {
                AddBanners(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(animatedBannersHeight)
                )
                CategoryPanel(
                    categories = state.categories,
                    activeCategory = state.activeCategory,
                    onCategoryChange = remember { viewModel::changeActiveCategory },
                    modifier = Modifier
                        .padding(AppTheme.sizes.menuScreen.categoriesPanel.categoriesPadding)
                        .fillMaxWidth()
                )
                LazyColumn(state = listScrollState) {
                    items(items = state.food, key = { it.id }) {
                        HorizontalDivider(thickness = 1.dp, color = Grey)
                        FoodCard(
                            item = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(AppTheme.sizes.menuScreen.foodCard.cardHeight)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun rememberNestedScrollConnection(
    onBannerHeightChange: (Float) -> Unit,
    appBarHeightPx: Float,
    listCanScrollBackwards: () -> Boolean
) = remember {
    var innerBannersHeight = appBarHeightPx
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            return if (available.y < 0) {
                if (innerBannersHeight > 0) {
                    changeInnerHeight(available)
                    onBannerHeightChange(innerBannersHeight)
                    available
                } else {
                    super.onPreScroll(available, source)
                }
            } else {
                if (listCanScrollBackwards()) {
                    super.onPreScroll(available, source)
                } else {
                    changeInnerHeight(available)
                    onBannerHeightChange(innerBannersHeight)
                    Offset.Zero
                }
            }
        }

        override fun onPostScroll(
            consumed: Offset,
            available: Offset,
            source: NestedScrollSource
        ): Offset {
            return if (available.y < 0) {
                super.onPostScroll(consumed, available, source)
            } else {
                changeInnerHeight(available)
                onBannerHeightChange(innerBannersHeight)
                available
            }
        }

        private fun changeInnerHeight(offset: Offset) {
            innerBannersHeight = (innerBannersHeight + offset.y).coerceIn(
                minimumValue = 0f,
                maximumValue = appBarHeightPx
            )
        }
    }
}
