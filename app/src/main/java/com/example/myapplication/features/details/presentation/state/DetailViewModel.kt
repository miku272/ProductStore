package com.example.myapplication.features.details.presentation.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.myapplication.core.common.domain.repository.ProductRepository
import com.example.myapplication.core.navigation.Details
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.myapplication.core.common.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ProductRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val productId =
        savedStateHandle
            .toRoute<Details>()
            .productId

    private val _uiState = MutableStateFlow(
        DetailUiState()
    )
    val uiState = _uiState.asStateFlow()

    init {
        observeProduct()
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            showRefreshing()
            try {
                repository.refreshProduct(productId)
            } catch (throwable: Throwable) {
                showError(throwable)
            }
        }
    }

    private fun observeProduct() {
        viewModelScope.launch {
            repository
                .observeProduct(productId)
                .collect { product ->
                    if (product != null) {
                        showProduct(product)
                    }
                }
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

    private fun showProduct(
        product: Product
    ) {
        _uiState.update {
            it.copy(
                product = product,
                isRefreshing = false,
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
                error = throwable.message
                    ?: "Something went wrong."
            )
        }
    }
}