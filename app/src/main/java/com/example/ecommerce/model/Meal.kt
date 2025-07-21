package com.example.ecommerce.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Meal(
    val id: Int,
    val name: String,
    val quantity: Int,
    val isFavorite: Boolean,
    val backGroundColor: Color,
    val price: Double,
    @DrawableRes val imageRes: Int,
    var category: Category? = null

)