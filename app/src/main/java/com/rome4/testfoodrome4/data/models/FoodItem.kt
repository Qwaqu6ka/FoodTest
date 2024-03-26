package com.rome4.testfoodrome4.data.models

import java.util.UUID

data class FoodItem(
    val id: String = UUID.randomUUID().toString(),
    val imageUrl: String,
    val title: String,
    val description: String,
    val price: Int,
    val categoryId: String,
)