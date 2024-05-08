package com.luceroobispo.applist_favoriteproducts.ui.shared

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.Product

@Composable
fun ProductList(products: MutableState<List<Product>>) {
    LazyColumn {
        items(products.value.size) { index ->
            ProductCard(products.value[index])
        }
    }
}