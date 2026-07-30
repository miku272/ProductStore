package com.example.myapplication.features.details.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.core.designsystem.Dimens

@Composable
fun DescriptionSection(
    description: String,
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
            "Description",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(Dimens.Spacing.Small))

        Text(
            description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DescriptionSectionPreview() {
    DescriptionSection(
        description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop up to 15 inches in the padded sleeve, your everyday essentials in the main compartment, and your smaller items in the front pocket."
    )
}