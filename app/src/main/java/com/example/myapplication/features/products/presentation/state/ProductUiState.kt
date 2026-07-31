package com.example.myapplication.features.products.presentation.state

import com.example.myapplication.core.common.domain.models.Product

data class ProductUiState(
    val products: List<Product> = emptyList(),
    val isInitialLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null
)
