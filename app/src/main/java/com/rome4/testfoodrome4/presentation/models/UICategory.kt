package com.rome4.testfoodrome4.presentation.models

import androidx.compose.runtime.Immutable
import com.rome4.testfoodrome4.data.models.Category

@Immutable
data class UICategory(
    val id: String = "",
    val title: String = ""
)

fun Category.mapToUI() = UICategory(
    id, title
)