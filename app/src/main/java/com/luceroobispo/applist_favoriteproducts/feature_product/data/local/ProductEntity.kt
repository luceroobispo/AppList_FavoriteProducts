package com.luceroobispo.applist_favoriteproducts.feature_product.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity (
    @PrimaryKey val id: Int,

    val title: String,
    val image: String,
    val imageType: String
)