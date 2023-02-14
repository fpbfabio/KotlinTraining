package com.training.stockapp.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.stockapp.ui.viewmodel.LoginViewModel
import com.training.stockapp.ui.viewmodel.StockViewModel


@Composable
fun AppNavigation(
    loginViewModel: LoginViewModel,
    stockViewModel: StockViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.StockList.name) {
        composable (AppScreen.Login.name) {
            val model by loginViewModel.model.collectAsState()
            LoginScreenView(model = model,  navController = navController)
        }
        composable (AppScreen.StockList.name) {
            val model by stockViewModel.model.collectAsState()
            StockListScreenView(model = model)
        }
    }
}