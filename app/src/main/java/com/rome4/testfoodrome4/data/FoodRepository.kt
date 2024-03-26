package com.rome4.testfoodrome4.data

import com.rome4.testfoodrome4.data.models.Category
import com.rome4.testfoodrome4.data.models.FoodItem

interface FoodRepository {

    suspend fun getFood(): List<FoodItem>

    suspend fun getCategories(): List<Category>

    suspend fun getCities(): List<String>
}