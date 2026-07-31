package com.example.myapplication.features.details.presentation.state

import com.example.myapplication.core.common.domain.models.Product

data class DetailUiState(
    val product: Product? = null,
    val isRefreshing: Boolean = false,
    val error: String? = null
) {
    val shouldShowLoading: Boolean
        get() = product == null &&
                isRefreshing &&
                error == null

    val shouldShowError: Boolean
        get() = product == null &&
                error != null

    val shouldShowContent: Boolean
        get() = product != null
}