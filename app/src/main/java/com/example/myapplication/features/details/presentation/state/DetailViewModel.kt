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
import com.example.myapplication.core.common.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val productId = savedStateHandle.toRoute<Details>().productId
    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    init {
        initialLoad()
    }

    fun refresh() {
        refreshProduct()
    }

    private fun initialLoad() {

        viewModelScope.launch {

            showInitialLoading()

            fetchProduct()

        }

    }

    private fun refreshProduct() {

        viewModelScope.launch {

            showRefreshing()

            fetchProduct()

        }

    }

    private suspend fun fetchProduct() {

        val result = productRepository
            .getProduct(productId)

        when (result) {
            is Result.Loading -> {}

            is Result.Success -> {
                showProduct(result.data)
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

    private fun showProduct(
        product: Product
    ) {

        _uiState.update {

            it.copy(
                product = product,
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