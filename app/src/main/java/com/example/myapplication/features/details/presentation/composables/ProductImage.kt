package com.example.myapplication.features.details.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.core.composables.NetworkImage
import com.example.myapplication.core.designsystem.Dimens

@Composable
fun ProductImage(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1F)
            .background(MaterialTheme.colorScheme.surfaceContainerLow),
        contentAlignment = Alignment.Center
    ) {
        NetworkImage(
            imageUrl = imageUrl,
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.Spacing.XLarge),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductImagePreview() {
    ProductImage(
        imageUrl = "",
        title = "Product"
    )
}