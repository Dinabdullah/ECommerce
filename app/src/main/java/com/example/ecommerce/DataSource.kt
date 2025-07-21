package com.example.ecommerce

import androidx.compose.ui.graphics.Color
import com.example.ecommerce.model.Category
import com.example.ecommerce.model.Meal

object DataSource {
    fun getMeals(): ArrayList<Meal> {
        val meals = arrayListOf<Meal>()
        meals.add(
            Meal(
                id = 1,
                name = "Honey lime",
                quantity = 0,
                backGroundColor = Color.White,
                price = 2000.0,
                category = Category.Hottest,
                isFavorite = false,
                imageRes = R.drawable.honey
            )
        )
        meals.add(
            Meal(
                id = 2,
                name = "Berry mango combo",
                quantity = 0,
                backGroundColor = Color.Red.copy(alpha = 0.75f),
                price = 2000.0,
                imageRes = R.drawable.glowingberryfruitsalad,
                category = Category.Popular,
                isFavorite = false
            ),
        )
        meals.add(
            Meal(
                id = 3,
                name = "Quinoa fruit salad",
                quantity = 0,
                backGroundColor = Color.Blue.copy(alpha = 0.5f),
                price = 500.0,
                imageRes = R.drawable.breakfast,
                category = Category.Hottest,
                isFavorite = false
            ),
        )
        meals.add(
            Meal(
                id = 4,
                name = "Tropical fruit salad",
                quantity = 0,
                backGroundColor = Color.Cyan.copy(alpha = 0.75f),
                price = 500.0,
                imageRes = R.drawable.best,
                category = Category.NewCombo,
                isFavorite = false
            ),
        )
        meals.add(
            Meal(
                id = 5,
                name = "Very big large family meal with 50 piece and big cola with freis and coleslaw with extra happy meal",
                quantity = 0,
                backGroundColor = Color.Yellow.copy(alpha = 0.75f),
                price = 500.0,
                imageRes = R.drawable.honey,
                category = Category.Top,
                isFavorite = false
            ),
        )
        return meals
    }

    fun getCategories(): List<String> {
        return listOf(
            Category.Hottest.title,
            Category.Popular.title,
            Category.NewCombo.title,
            Category.Top.title
        )
    }


}