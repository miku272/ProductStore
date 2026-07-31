package com.example.myapplication.core.common.domain.repository

import com.example.myapplication.core.common.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun observeProducts(): Flow<List<Product>>

    fun observeProduct(
        id: Int
    ): Flow<Product?>

    suspend fun refreshProducts()

    suspend fun refreshProduct(
        id: Int
    )
}