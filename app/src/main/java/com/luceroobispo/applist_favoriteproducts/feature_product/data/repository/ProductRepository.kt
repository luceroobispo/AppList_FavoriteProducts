package com.luceroobispo.applist_favoriteproducts.feature_product.data.repository

import android.util.Log
import com.luceroobispo.applist_favoriteproducts.feature_product.data.local.ProductEntity
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.Product
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.ProductWrapper
import com.luceroobispo.applist_favoriteproducts.feature_product.data.remote.ProductDaoFactory
import com.luceroobispo.applist_favoriteproducts.feature_product.data.remote.ProductServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private val productService = ProductServiceFactory.getProductService()
    private val productDao = ProductDaoFactory.getProductDao()

    fun getProducts(query: String, number: Int, callback: (List<Product>) -> Unit) {
        val call = productService.getProducts(query, number)
        call.enqueue(object : Callback<ProductWrapper> {
            override fun onResponse(
                call: Call<ProductWrapper>,
                response: Response<ProductWrapper>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()?.products ?: emptyList()
                    if (products.isNotEmpty()) {
                        products.forEach { product ->
                            product.isFavorite = isFavorite(product.id)
                        }
                    }

                    callback(products)
                } else {
                    Log.d("ProductRepository", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ProductWrapper>, t: Throwable) {
                t.message?.let {
                    Log.d("ProductRepository", it)
                }
            }
        })
    }

    fun isFavorite(id: Int): Boolean {
        return productDao.getById(id) != null
    }

    fun addFavorite(product: Product) {
        product.id.let { id ->
            productDao.insert(
                ProductEntity(
                    id = id,
                    title = product.title,
                    image = product.image,
                    imageType = product.imageType
                )
            )
        }
    }

    fun deleteFavorite(product: Product) {
        product.id.let { id ->
            productDao.delete(
                ProductEntity(
                    id = id,
                    title = product.title,
                    image = product.image,
                    imageType = product.imageType
                )
            )
        }
    }

    fun getFavorites(callback: (List<Product>) -> Unit) {
        val products = productDao.getAll().map{
            Product(id = it.id, title = it.title, image = it.image, imageType =  it.imageType)
        }
        callback(products)
    }
}