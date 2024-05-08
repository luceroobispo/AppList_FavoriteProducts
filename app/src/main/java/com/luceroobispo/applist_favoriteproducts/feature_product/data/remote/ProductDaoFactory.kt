package com.luceroobispo.applist_favoriteproducts.feature_product.data.remote

import com.luceroobispo.applist_favoriteproducts.MyApplication
import com.luceroobispo.applist_favoriteproducts.core_database.AppDatabase
import com.luceroobispo.applist_favoriteproducts.feature_product.data.local.ProductDao

class ProductDaoFactory private constructor() {
    companion object {
        private var productDao: ProductDao? = null
        fun getProductDao(): ProductDao {
            if (productDao == null) {
                productDao = AppDatabase.getAppDatabase(MyApplication.getContext()).productDao()
            }
            return productDao as ProductDao
        }
    }
}