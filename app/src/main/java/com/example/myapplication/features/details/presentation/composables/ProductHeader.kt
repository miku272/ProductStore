package com.example.myapplication.features.details.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.core.designsystem.Dimens

@Composable
fun ProductHeader(
    category: String,
    title: String,
    rating: Double,
    reviewCount: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.Spacing.Large,
                vertical = Dimens.Spacing.XLarge,
            )
    ) {
        AssistChip(
            onClick = { },
            enabled = false,
            label = { Text(category) }
        )

        Spacer(modifier = Modifier.height(Dimens.Spacing.Large))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(Dimens.Spacing.Medium))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = null,
                tint = Color(0xFFFFC107)
            )

            Spacer(
                modifier = Modifier.width(Dimens.Spacing.XSmall)
            )

            Text(
                text = "%.1f".format(rating)
            )

            Spacer(
                modifier = Modifier.width(Dimens.Spacing.Small)
            )

            Text("•")

            Spacer(
                modifier = Modifier.width(Dimens.Spacing.Small)
            )

            Text(
                text = "$reviewCount reviews",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHeaderPreview() {
    ProductHeader(
        category = "Category",
        title = "Product Title",
        rating = 4.5,
        reviewCount = 10
    )
}