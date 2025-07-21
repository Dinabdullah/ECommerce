package com.example.ecommerce.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ecommerce.Screen
import com.example.ecommerce.componants.CartBox
import com.example.ecommerce.componants.CategoryRow
import com.example.ecommerce.componants.CustomMealItem
import com.example.ecommerce.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(),
    navController: NavHostController
) {
    val mainState = viewModel.mainState.collectAsStateWithLifecycle().value

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CartBox(
            modifier = modifier
                .padding(top = 16.dp)
                .align(Alignment.End),
            quantity = mainState.cartCount,
            onCartClick = {
                navController.navigate(Screen.Cart.route)
            }
        )
        Text(
            text = "Recommended Combo",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = modifier.padding(
                vertical = 8.dp
            )
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(23.dp)) {
            items(mainState.meals) { meal ->
                CustomMealItem(
                    modifier = Modifier,
                    meal = meal,
                    onEvent = { viewModel.onEvent(it) }
                )
            }
        }

        CategoryRow(
            meals = mainState.meals,
            onEvent = { viewModel.onEvent(it) },
            categories = mainState.categories,
            filteredMeals = { mainState.filteredMeals }
        )

    }
}


//@Preview
//@Composable
//private fun HomeScreenPreview() {
//    HomeScreen(
//    )
//}
