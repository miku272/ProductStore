package com.example.myapplication.features.products.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.core.common.models.Product
import com.example.myapplication.core.designsystem.Dimens

@Composable
fun ProductsList(
    products: List<Product>,
    onProductClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Dimens.Spacing.Medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(
            items = products,
            key = { it.id }
        ) { product ->

            ProductsCard(
                product = product,
                onClick = {
                    onProductClick(product.id)
                }
            )

        }

    }
}