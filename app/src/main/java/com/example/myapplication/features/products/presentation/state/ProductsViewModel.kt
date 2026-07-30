package com.example.myapplication.features.products.presentation.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.common.Result
import com.example.myapplication.core.common.models.Product
import com.example.myapplication.core.common.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState())
    val uiState = _uiState.asStateFlow()

    init {
        initialLoad()
    }

    fun refresh() {
        refreshProducts()
    }

    private fun initialLoad() {

        viewModelScope.launch {

            showInitialLoading()

            fetchProducts()
        }
    }

    private fun refreshProducts() {

        viewModelScope.launch {

            showRefreshing()

            fetchProducts()
        }
    }

    private suspend fun fetchProducts() {

        val result = productRepository
            .getProducts()

        when (result) {
            is Result.Loading -> { }

            is Result.Success -> {
                showProducts(result.data)
            }

            is Result.Error -> {
                showError()
            }
        }

    }

    private fun showInitialLoading() {

        _uiState.update {

            it.copy(
                isInitialLoading = true,
                isRefreshing = false,
                error = null
            )

        }
    }

    private fun showRefreshing() {

        _uiState.update {

            it.copy(
                isRefreshing = true,
                error = null
            )

        }
    }

    private fun showProducts(
        products: List<Product>
    ) {

        _uiState.update {

            it.copy(
                products = products,
                isInitialLoading = false,
                isRefreshing = false,
                error = null
            )

        }
    }

    private fun showError() {

        _uiState.update {

            it.copy(
                isInitialLoading = false,
                isRefreshing = false,
                error = "Something went wrong."
            )

        }
    }
}
