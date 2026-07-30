package com.example.myapplication.features.details.presentation.state

import com.example.myapplication.core.common.models.Product

sealed interface DetailState {
    data object Loading: DetailState

    data class Success(
        val product: Product
    ): DetailState

    data class Error(
        val message: String
    ): DetailState
}