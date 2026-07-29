package com.example.myapplication.features.products.presentation.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.common.Result
import com.example.myapplication.features.products.data.repository.ProductRepository
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
    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            _uiState.update {
                ProductUiState.Loading
            }

            when (val result = productRepository.getProducts()) {
                is Result.Loading -> {
                    _uiState.update {
                        ProductUiState.Loading
                    }
                }

                is Result.Success -> {
                    _uiState.update {
                        ProductUiState.Success(products = result.data)
                    }
                }

                is Result.Error -> {
                    _uiState.update {
                        ProductUiState.Error(message = result.message)
                    }
                }
            }
        }

    }
}
