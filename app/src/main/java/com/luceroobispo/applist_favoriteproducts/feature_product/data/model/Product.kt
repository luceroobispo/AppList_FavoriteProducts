package com.luceroobispo.applist_favoriteproducts.feature_product.data.model

data class ProductWrapper(
    val products: List<Product>
)

data class Product(
    var isFavorite: Boolean = false,

    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)
