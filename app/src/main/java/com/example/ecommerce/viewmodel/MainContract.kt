package com.example.ecommerce.viewmodel

import com.example.ecommerce.model.Meal

class MainContract {
    data class MainState(
        val meals: ArrayList<Meal> = arrayListOf(),
        val categories: List<String> = arrayListOf(),
        val selectedCategoryIndex: Int = 0,
        val cartCount: Int = 0,
        val filteredMeals: List<Meal> = emptyList()
    )

    sealed class MealEvents {
        object LoadProducts : MealEvents()
        data class ItemClick(val id: Int) : MealEvents()
        data class FavouriteClick(val id: Int) : MealEvents()
        data class PlusClick(val id: Int) : MealEvents()

        data class CategoryClick(val categoryId: Int) : MealEvents()

        object GetCartCount : MealEvents()

        object CartClick : MealEvents()


    }
}