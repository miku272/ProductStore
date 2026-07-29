package com.example.myapplication.features.products.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplication.features.products.presentation.state.ProductsViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.TextStyle
import com.example.myapplication.features.products.presentation.state.ProductUiState

@Composable
fun ProductsScreen(
    onProductClick: (Int) -> Unit
) {
    val viewModel: ProductsViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            when (state) {
                is ProductUiState.Loading -> CircularProgressIndicator()

                is ProductUiState.Success -> {
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items((state as ProductUiState.Success).products) { product ->
                            Row(

                            ) {
                                Text(
                                    text = product.title,
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Button(onClick = { onProductClick(product.id) }) {
                                    Text("Go to Details")
                                }
                            }
                        }
                    }
                }

                is ProductUiState.Error -> {
                    Text(text = (state as ProductUiState.Error).message)
                }
            }
        }
    }
}