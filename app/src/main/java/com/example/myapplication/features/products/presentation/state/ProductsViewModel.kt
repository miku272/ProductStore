package com.example.myapplication.features.products.presentation.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.common.Result
import com.example.myapplication.core.common.domain.models.Product
import com.example.myapplication.core.common.datasource.repository.ProductRepositoryImpl
import com.example.myapplication.core.common.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        ProductsUiState()
    )

    val uiState = _uiState.asStateFlow()

    init {
        observeProducts()
        refresh()
    }

    fun refresh() {

        viewModelScope.launch {

            showRefreshing()

            try {

                repository.refreshProducts()

            } catch (throwable: Throwable) {

                showError(throwable)

            }

        }

    }

    private fun observeProducts() {

        viewModelScope.launch {

            repository
                .observeProducts()
                .collect(::showProducts)

        }

    }

    private fun showProducts(
        products: List<Product>
    ) {

        _uiState.update {

            it.copy(
                products = products,
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

    private fun showError(
        throwable: Throwable
    ) {

        _uiState.update {

            it.copy(
                isRefreshing = false,
                error = throwable.message ?: "Something went wrong."
            )

        }

    }

}
