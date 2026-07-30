package com.example.myapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.myapplication.features.details.presentation.DetailsScreen
import com.example.myapplication.features.favorites.presentation.screens.FavoritesScreen
import com.example.myapplication.features.products.presentation.ProductsScreen
import com.example.myapplication.features.settings.presentation.screens.SettingsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Products
    ) {
        composable<Products> {
            ProductsScreen(
                onProductClick = { productId ->
                    navController.navigate(Details(productId = productId))
                }
            )
        }
        composable<Details> {
            DetailsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable<Favorites> {
            FavoritesScreen()
        }
        composable<Settings> {
            SettingsScreen()
        }
    }
}