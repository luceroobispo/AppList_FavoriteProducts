package com.luceroobispo.applist_favoriteproducts.feature_home.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luceroobispo.applist_favoriteproducts.feature_home.ui.screens.WelcomeScreen
import com.luceroobispo.applist_favoriteproducts.feature_product.ui.screens.FavoriteProductsScreen
import com.luceroobispo.applist_favoriteproducts.feature_product.ui.screens.ProductListScreen


@Composable
fun HomeScreen() {
    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            WelcomeScreen(navController)
        }
        composable(Routes.Favorites.route) {
            FavoriteProductsScreen()
        }
        composable(Routes.Product.route) {
            ProductListScreen()
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("WelcomeScreen")
    data object Product : Routes("ProductListScreen")
    data object Favorites : Routes("FavoriteProductsScreen")
}