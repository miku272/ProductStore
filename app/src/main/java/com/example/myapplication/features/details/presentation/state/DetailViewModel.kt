package com.example.myapplication.features.details.presentation.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.myapplication.core.common.repository.ProductRepository
import com.example.myapplication.core.navigation.Details
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.myapplication.core.common.Result

class DetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val productId = savedStateHandle.toRoute<Details>().productId
    private val _uiState = MutableStateFlow<DetailState>(DetailState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadProduct()
    }

    private fun loadProduct() {
        viewModelScope.launch {
            _uiState.update {
                DetailState.Loading
            }

            when (val result = productRepository.getProduct(productId)) {
                is Result.Loading -> {
                    _uiState.update {
                        DetailState.Loading
                    }
                }

                is Result.Success -> {
                    _uiState.update {
                        DetailState.Success(result.data)
                    }
                }

                is Result.Error -> {
                    _uiState.update {
                        DetailState.Error(message = result.message ?: "Unknown error")
                    }
                }
            }
        }
    }

    fun retry() {
        loadProduct()
    }
}