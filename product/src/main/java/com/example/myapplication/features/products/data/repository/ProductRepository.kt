package com.example.myapplication.features.products.data.repository

import com.example.myapplication.features.products.data.datasource.ProductApi
import com.example.myapplication.features.products.data.mapper.toDomain
import com.example.myapplication.features.products.domain.models.Product
import jakarta.inject.Inject
import com.example.myapplication.core.common.Result

class ProductRepository @Inject constructor(
    private val productApi: ProductApi
) {
    suspend fun getProducts(): Result<List<Product>> {
        return try {
            val products = productApi.getProducts().map { it.toDomain() }

            Result.Success(products)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error", e)
        }
    }
}