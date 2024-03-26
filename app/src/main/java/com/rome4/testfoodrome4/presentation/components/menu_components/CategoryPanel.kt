package com.rome4.testfoodrome4.presentation.components.menu_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rome4.testfoodrome4.presentation.components.FoodButton
import com.rome4.testfoodrome4.presentation.components.UnselectedFoodButton
import com.rome4.testfoodrome4.presentation.models.UICategory
import com.rome4.testfoodrome4.presentation.theme.AppTheme
import kotlinx.collections.immutable.ImmutableList

@Composable
fun CategoryPanel(
    categories: ImmutableList<UICategory>,
    activeCategory: UICategory,
    onCategoryChange: (UICategory) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(AppTheme.sizes.menuScreen.categoriesPanel.categoriesArrangement)
    ) {
        item {
            Spacer(modifier = Modifier.width(AppTheme.sizes.menuScreen.categoriesPanel.startEndSpacer))
        }
        items(items = categories, key = { it.id }) {
            if (it.id == activeCategory.id) {
                FoodButton(text = it.title, onClick = { onCategoryChange(it) })
            } else {
                UnselectedFoodButton(text = it.title, onClick = { onCategoryChange(it) })
            }
        }
        item {
            Spacer(modifier = Modifier.width(AppTheme.sizes.menuScreen.categoriesPanel.startEndSpacer))
        }
    }
}