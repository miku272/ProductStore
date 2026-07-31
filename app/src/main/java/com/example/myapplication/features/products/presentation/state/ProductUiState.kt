package com.example.myapplication.features.products.presentation.state

import com.example.myapplication.core.common.domain.models.Product

data class ProductsUiState(

    val products: List<Product> = emptyList(),

    val isRefreshing: Boolean = false,

    val error: String? = null
) {

    val shouldShowLoading: Boolean
        get() = products.isEmpty() &&
                isRefreshing &&
                error == null

    val shouldShowEmpty: Boolean
        get() = products.isEmpty() &&
                !isRefreshing &&
                error == null

    val shouldShowError: Boolean
        get() = products.isEmpty() &&
                error != null

    val shouldShowProducts: Boolean
        get() = products.isNotEmpty()

}