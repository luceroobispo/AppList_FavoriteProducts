package com.luceroobispo.applist_favoriteproducts.feature_product.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.Product
import com.luceroobispo.applist_favoriteproducts.feature_product.data.repository.ProductRepositoryFactory
import com.luceroobispo.applist_favoriteproducts.ui.shared.ProductList

@Composable
fun ProductListScreen() {
    val productName = remember { mutableStateOf("") }
    val quantity = 10
    val products = remember { mutableStateOf(emptyList<Product>()) }

    val productRepository = ProductRepositoryFactory.getProductRepository()

    Scaffold {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            SearchBar(productName) {
                productRepository.getProducts(productName.value, quantity) { response ->
                    products.value = response
                }
            }
            ProductList(products)
        }

    }
}

@Composable
fun SearchBar(productName: MutableState<String>, onShowProductsClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = productName.value,
            onValueChange = {
                productName.value = it
            },
            placeholder = {
                Text(text = "Product name")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onShowProductsClick,
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text("Show")
        }
    }
}