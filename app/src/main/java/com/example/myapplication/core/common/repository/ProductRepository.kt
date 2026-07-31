package com.example.myapplication.core.common.repository

import com.example.myapplication.core.common.Result
import com.example.myapplication.core.common.datasource.remote.ProductApi
import com.example.myapplication.core.common.datasource.remote.mapper.toDomain
import com.example.myapplication.core.common.domain.models.Product
import jakarta.inject.Inject

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

    suspend fun getProduct(id: Int): Result<Product> {
        return try {
            val product = productApi.getProduct(id).toDomain()

            Result.Success(product)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error", e)
        }
    }
}