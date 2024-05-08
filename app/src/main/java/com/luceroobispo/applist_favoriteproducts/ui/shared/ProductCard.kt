package com.luceroobispo.applist_favoriteproducts.ui.shared


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.Product
import com.luceroobispo.applist_favoriteproducts.feature_product.data.repository.ProductRepositoryFactory
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ProductCard(product: Product) {
    val isFavorite = remember {
        mutableStateOf(false)
    }
    isFavorite.value = product.isFavorite ?: false

    val productRepository = ProductRepositoryFactory.getProductRepository()


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
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

                if (isFavorite.value) {
                    productRepository.addFavorite(product)
                } else {
                    productRepository.deleteFavorite(product)
                }
            }) {
                Icon(
                    Icons.Filled.Favorite, "Favorite", tint =
                    if (isFavorite.value) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Gray
                    }

                )
            }
        }
    }
}
