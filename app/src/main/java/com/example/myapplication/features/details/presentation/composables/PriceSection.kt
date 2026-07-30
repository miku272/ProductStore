package com.example.myapplication.features.details.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.core.common.CurrencyFormatter
import com.example.myapplication.core.designsystem.Dimens

@Composable
fun PriceSection(
    price: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.Spacing.Large,
                vertical = Dimens.Spacing.XLarge
            )
    ) {
        Text(
            text = CurrencyFormatter.format(price),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PriceSectionPreview() {
    PriceSection(
        price = 23.98
    )
}