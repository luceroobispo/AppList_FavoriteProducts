package com.luceroobispo.applist_favoriteproducts.ui.shared

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.Product
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ProductCard(product: Product) {
    val isFavorite = remember { mutableStateOf(product.isFavorite) }
    isFavorite.value = product.isFavorite

    //val productRepository = ProductRepositoryFactory.getProductRepository()


    Card( modifier = Modifier.padding(4.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            GlideImage(
                imageModel = { product.image },
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(18.dp, 0.dp)
            ) {
                Text(text = "Id: ${product.id}")
                Text(text = "Name: ${product.title}")
            }
            IconButton(onClick = {
                isFavorite.value = !isFavorite.value
                product.isFavorite = isFavorite.value
                /*
                if (isFavorite.value == true) {
                    productRepository.addFavorite(product)
                    product.isFavorite = true
                } else {
                    productRepository.deleteFavorite(product)
                    product.isFavorite = false
                }
                */
            }) {
                Icon(
                    Icons.Filled.Favorite,
                    tint = if(isFavorite.value) Color.Red else Color.White,
                    contentDescription = "Favorite"
                )
            }
        }
    }
}