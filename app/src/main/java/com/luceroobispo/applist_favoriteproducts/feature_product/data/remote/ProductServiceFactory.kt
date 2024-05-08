package com.luceroobispo.applist_favoriteproducts.feature_product.data.remote

import com.luceroobispo.applist_favoriteproducts.core_network.RetrofitFactory

class ProductServiceFactory private constructor() {
    companion object {

        private var productService: ProductService? = null

        fun getProductService(): ProductService {
            if (productService == null) {
                productService = RetrofitFactory.getRetrofit().create(ProductService::class.java)
            }
            return productService as ProductService
        }
    }
}