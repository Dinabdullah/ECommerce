package com.example.ecommerce.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ecommerce.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _mainState = MutableStateFlow(MainContract.MainState())
    val mainState = _mainState

    init {
        onEvent(MainContract.MealEvents.LoadProducts)
    }

    fun onEvent(event: MainContract.MealEvents) {
        when (event) {
            MainContract.MealEvents.LoadProducts -> loadProducts()
            is MainContract.MealEvents.FavouriteClick -> onFavoriteClick(event.id)
            is MainContract.MealEvents.ItemClick -> onItemClick(event.id)
            is MainContract.MealEvents.PlusClick -> onPlusClick(event.id)
            is MainContract.MealEvents.CategoryClick -> onCategoryClick(event.categoryId)
            is MainContract.MealEvents.CartClick -> onCartClick()
            is MainContract.MealEvents.GetCartCount -> getCartCount()
        }
    }


    private fun getCartCount() {
        _mainState.update { it ->
            it.copy(
                cartCount = it.meals.sumOf { it.quantity }

            )
        }
    }

    private fun onCartClick() {
    }



    private fun onCategoryClick(categoryIndex: Int) {
        val selectedCategory = _mainState.value.categories.getOrNull(categoryIndex)
        val filtered = _mainState.value.meals.filter {
            it.category?.title == selectedCategory
        }

        _mainState.update {
            it.copy(
                selectedCategoryIndex = categoryIndex,
                filteredMeals = filtered
            )
        }
    }




    private fun onPlusClick(id: Int) {
        _mainState.update {
            it.copy(
                meals = it.meals.map { meal ->
                    if (meal.id == id) {
                        meal.copy(quantity = meal.quantity + 1)

                    } else {
                        meal
                    }

                } as ArrayList
            )
        }
        getCartCount()
    }


    private fun onItemClick(id: Int) {}

    private fun onFavoriteClick(id: Int) {
        _mainState.update {
            it.copy(
                meals = it.meals.map { meal ->
                    if (meal.id == id)
                        meal.copy(isFavorite = meal.isFavorite.not())
                    else
                        meal
                } as ArrayList
            )
        }
    }

    private fun loadProducts() {
        val meals = DataSource.getMeals()
        val categories = DataSource.getCategories()
        val selectedCategory = categories.getOrNull(0)
        _mainState.value = _mainState.value.copy(
            meals = meals,
            categories = categories,
            filteredMeals = meals.filter { it.category?.title == selectedCategory }
        )
    }



}