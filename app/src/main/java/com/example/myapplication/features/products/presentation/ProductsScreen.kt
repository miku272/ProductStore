package com.example.myapplication.features.products.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplication.features.products.presentation.state.ProductsViewModel
import androidx.compose.runtime.getValue
import com.example.myapplication.core.composables.EmptyView
import com.example.myapplication.core.designsystem.Dimens
import com.example.myapplication.core.composables.ErrorView
import com.example.myapplication.features.products.presentation.composables.ProductsCard
import com.example.myapplication.features.products.presentation.composables.ProductsList
import com.example.myapplication.features.products.presentation.composables.ProductsTopBar
import com.example.myapplication.features.products.presentation.state.ProductUiState

@Composable
fun ProductsScreen(
    onProductClick: (Int) -> Unit
) {
    val viewModel: ProductsViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { ProductsTopBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = Dimens.Spacing.Medium)
                .fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            when {
                state.isInitialLoading -> CircularProgressIndicator()

                state.error != null && state.products.isEmpty() -> {
                    ErrorView(
                        message = state.error!!,
                        onRetry = viewModel::refresh
                    )
                }

                else -> {
                    PullToRefreshBox(
                        isRefreshing = state.isRefreshing,
                        onRefresh = viewModel::refresh,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        if (state.products.isEmpty()) {
                            EmptyView(
                                onAction = viewModel::refresh,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            ProductsList(
                                products = state.products,
                                onProductClick = onProductClick
                            )
                        }
                    }
                }
            }
        }
    }
}