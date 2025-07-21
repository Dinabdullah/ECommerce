package com.example.ecommerce.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.model.Meal
import com.example.ecommerce.viewmodel.MainContract

@Composable
fun CartScreen(
    meals: List<Meal>,
    onEvent: (MainContract.MealEvents) -> Unit
) {
    val cartItems = meals.filter { it.quantity > 0 }
    val totalPrice = cartItems.sumOf { it.quantity * it.price }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Shopping Cart",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(cartItems) { meal ->
                CartItemRow(
                    meal = meal,
                    onEvent = onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

            }
        }

        Text(
            text = "total{$totalPrice}",
            style = MaterialTheme.typography.titleLarge
        )

    }
}


@Composable
fun CartItemRow(
    meal: Meal,
    onEvent: (MainContract.MealEvents) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = meal.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Quantity :${meal.quantity}", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Total Price : ${meal.price * meal.quantity}",
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}
