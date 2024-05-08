package com.luceroobispo.applist_favoriteproducts.feature_product.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.Product
import com.luceroobispo.applist_favoriteproducts.ui.shared.ProductList
import com.luceroobispo.applist_favoriteproducts.feature_product.data.repository.ProductRepositoryFactory


@Composable
fun FavoriteProductsScreen() {
    val productRepository = ProductRepositoryFactory.getProductRepository()
    val products = remember { mutableStateOf(emptyList<Product>()) }

    productRepository.getFavorites { favouriteProducts ->
        products.value = favouriteProducts
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Favourite Products")
            ProductList(products = products)
        }

    }
}