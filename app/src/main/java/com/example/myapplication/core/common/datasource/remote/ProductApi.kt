package com.example.myapplication.core.common.datasource.remote

import com.example.myapplication.core.common.datasource.remote.entities.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>

    @GET("products/{id}")
    suspend fun getProduct(
        @Path("id") id: Int
    ): ProductDto
}