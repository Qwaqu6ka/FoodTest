package com.rome4.testfoodrome4.presentation.models

import androidx.compose.runtime.Immutable
import com.rome4.testfoodrome4.data.models.FoodItem

@Immutable
data class UiFoodItem(
    val id: String,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    val categoryId: String
)

fun FoodItem.mapToUI() = UiFoodItem(
    id = id,
    title = title,
    description = description,
    price = price,
    imageUrl = imageUrl,
    categoryId = categoryId
)
