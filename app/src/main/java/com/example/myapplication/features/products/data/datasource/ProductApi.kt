package com.example.myapplication.features.products.data.datasource

import com.example.myapplication.features.products.data.entities.ProductDto
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>
}