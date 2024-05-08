package com.luceroobispo.applist_favoriteproducts.feature_product.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getById(id: Int): ProductEntity

    @Insert
    fun insert(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)
}