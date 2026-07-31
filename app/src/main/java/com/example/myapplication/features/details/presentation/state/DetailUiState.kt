package com.example.myapplication.features.details.presentation.state

import com.example.myapplication.core.common.models.Product

data class DetailUiState(
    val product: Product? = null,
    val isInitialLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val error: String? = null
)