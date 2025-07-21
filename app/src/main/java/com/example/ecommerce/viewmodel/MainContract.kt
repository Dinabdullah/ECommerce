package com.example.ecommerce.viewmodel

import com.example.ecommerce.model.Meal

class MainContract {
    data class MainState(
        val meals: ArrayList<Meal> = arrayListOf(),
        val cartCount: Int = 0
    )

    sealed class MealEvents {
        object LoadProducts : MealEvents()
        data class ItemClick(val id: Int) : MealEvents()
        data class FavouriteClick(val id: Int) : MealEvents()
        data class PlusClick(val id: Int) : MealEvents()

        data class CategoryClick(val categoryId: Int) : MealEvents()

        object CartClick : MealEvents()

    }
}