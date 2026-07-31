package com.example.myapplication.core.common.datasource.repository

import com.example.myapplication.core.common.Result
import com.example.myapplication.core.common.datasource.local.dao.ProductDao
import com.example.myapplication.core.common.datasource.local.mapper.toDomain
import com.example.myapplication.core.common.datasource.local.mapper.toEntity
import com.example.myapplication.core.common.datasource.remote.ProductApi
import com.example.myapplication.core.common.datasource.remote.mapper.toDomain
import com.example.myapplication.core.common.datasource.remote.mapper.toEntity
import com.example.myapplication.core.common.domain.models.Product
import com.example.myapplication.core.common.domain.repository.ProductRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl @Inject constructor(
    private val productApi: ProductApi,
    private val productDao: ProductDao
) : ProductRepository {
    override fun observeProducts(): Flow<List<Product>> {
        return productDao
            .observeAll()
            .map { entities ->
                entities.map { it.toDomain() }
            }
    }

    override fun observeProduct(id: Int): Flow<Product?> {
        return productDao
            .observeById(id)
            .map { it?.toDomain() }
    }

    override suspend fun refreshProducts() {
        val products = productApi
            .getProducts()
            .map { dto ->
                dto.toEntity()
            }

        productDao.replaceProducts(products)
    }

    override suspend fun refreshProduct(id: Int) {
        val product = productApi
            .getProduct(id)
            .toEntity()

        productDao.insertProduct(product)
    }
}