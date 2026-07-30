package com.example.myapplication.features.details.presentation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplication.core.composables.ErrorView
import com.example.myapplication.core.designsystem.Dimens
import com.example.myapplication.features.details.presentation.composables.DescriptionSection
import com.example.myapplication.features.details.presentation.composables.DetailsTopBar
import com.example.myapplication.features.details.presentation.composables.PriceSection
import com.example.myapplication.features.details.presentation.composables.ProductHeader
import com.example.myapplication.features.details.presentation.composables.ProductImage
import com.example.myapplication.features.details.presentation.state.DetailState
import com.example.myapplication.features.details.presentation.state.DetailViewModel

@Composable
fun DetailsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { DetailsTopBar(onBackClick = onBackClick, onFavoriteClick = { }) }
    ) { innerPadding ->
        when (state) {
            is DetailState.Loading -> {
                CircularProgressIndicator()
            }

            is DetailState.Success -> {
                val product = (state as DetailState.Success).product

                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(horizontal = Dimens.Spacing.Medium)
                        .verticalScroll(rememberScrollState())
                ) {
                    ProductImage(
                        imageUrl = product.image,
                        title = product.title
                    )

                    HorizontalDivider(modifier = Modifier.padding(top = Dimens.Spacing.Small))

                    ProductHeader(
                        category = product.category,
                        title = product.title,
                        rating = product.rating.rate,
                        reviewCount = product.rating.count
                    )

                    HorizontalDivider(modifier = Modifier.padding(top = Dimens.Spacing.Small))

                    PriceSection(price = product.price)

                    HorizontalDivider(modifier = Modifier.padding(top = Dimens.Spacing.Small))

                    DescriptionSection(description = product.description)

                }
            }

            is DetailState.Error -> {
                ErrorView(
                    message = (state as DetailState.Error).message,
                    onRetry = viewModel::retry
                )
            }
        }
    }
}