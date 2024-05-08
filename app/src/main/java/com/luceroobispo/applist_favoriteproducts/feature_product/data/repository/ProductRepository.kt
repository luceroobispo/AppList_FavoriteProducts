package com.luceroobispo.applist_favoriteproducts.feature_product.data.repository

import android.util.Log
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.Product
import com.luceroobispo.applist_favoriteproducts.feature_product.data.model.ProductWrapper
import com.luceroobispo.applist_favoriteproducts.feature_product.data.remote.ProductServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private val productService = ProductServiceFactory.getProductService()

    fun getProducts(query: String, number: Int, callback: (List<Product>) -> Unit) {
        val getProducts = productService.getProducts(query,number)

        getProducts.enqueue(object: Callback<ProductWrapper> {
            override fun onResponse(call: Call<ProductWrapper>, response: Response<ProductWrapper>) {
                if (response.isSuccessful) {
                    val products = response.body()?.products ?: emptyList()
                    callback(products)
                    /*
                    if(products.isNotEmpty()) {
                        products.forEach{product->
                            product.isFavorite = isFavorite(product.id)
                        }
                    }*/
                }
            }

            override fun onFailure(call: Call<ProductWrapper>, t: Throwable) {
                t.message?.let {
                    Log.d("ProductRepository", it)
                }
            }
        })
    }
}