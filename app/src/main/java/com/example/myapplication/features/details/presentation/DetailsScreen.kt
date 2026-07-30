package com.example.myapplication.features.details.presentation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.core.designsystem.Dimens
import com.example.myapplication.features.details.presentation.composables.DescriptionSection
import com.example.myapplication.features.details.presentation.composables.DetailsTopBar
import com.example.myapplication.features.details.presentation.composables.PriceSection
import com.example.myapplication.features.details.presentation.composables.ProductHeader
import com.example.myapplication.features.details.presentation.composables.ProductImage

@Composable
fun DetailsScreen(productId: Int, onBackClick: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { DetailsTopBar(onBackClick = onBackClick, onFavoriteClick = { }) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = Dimens.Spacing.Medium)
                .verticalScroll(rememberScrollState())
        ) {
            ProductImage(
                imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                title = "Backpack"
            )

            HorizontalDivider(modifier = Modifier.padding(top = Dimens.Spacing.Small))

            ProductHeader(
                category = "Men's Clothing",
                title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                rating = 3.9,
                reviewCount = 120
            )

            HorizontalDivider(modifier = Modifier.padding(top = Dimens.Spacing.Small))

            PriceSection(price = 19.99)

            HorizontalDivider(modifier = Modifier.padding(top = Dimens.Spacing.Small))

            DescriptionSection(description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop up to 15 inches in the padded sleeve, your everyday essentials in the main compartment, and your smaller items in the front pocket.")

        }
    }
}