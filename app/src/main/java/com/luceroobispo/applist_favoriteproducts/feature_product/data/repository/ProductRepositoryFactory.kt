package com.luceroobispo.applist_favoriteproducts.feature_product.data.repository

class ProductRepositoryFactory private constructor() {
    companion object {
        private var productRepository: ProductRepository? = null

        fun getProductRepository(): ProductRepository {
            if (productRepository == null) {
                productRepository = ProductRepository()
            }
            return productRepository as ProductRepository
        }
    }
}