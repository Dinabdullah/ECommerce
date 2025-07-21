package com.example.ecommerce

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.screens.CartScreen
import com.example.ecommerce.screens.HomeScreen
import com.example.ecommerce.viewmodel.MainViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AppNavGraph(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                modifier = Modifier,
                viewModel = viewModel,
                navController = navController
            )
        }


        composable(Screen.Cart.route) {
            CartScreen(
                meals = viewModel.mainState.value.meals,
                onEvent = { viewModel.onEvent(it) }
            )
        }
    }
}
