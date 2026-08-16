package com.example.myapplication.features.products.presentation.state

import com.example.myapplication.features.products.domain.models.Product

sealed interface ProductUiState {

    data object Loading : ProductUiState

    data class Success(
        val products: List<Product>
    ) : ProductUiState

    data class Error(
        val message: String
    ) : ProductUiState
}
