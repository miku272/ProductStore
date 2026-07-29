package com.example.myapplication.features.products.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.myapplication.core.designsystem.AppElevation
import com.example.myapplication.core.designsystem.AppShapes
import com.example.myapplication.core.designsystem.Dimens
import com.example.myapplication.features.products.domain.models.Product

@Composable
fun ProductsCard(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = AppShapes.Medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppElevation.Card
        ),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.padding(Dimens.Spacing.Medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(Dimens.Size.ProductImage)
                    .clip(AppShapes.Medium)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )

            Spacer(
                modifier = Modifier
                    .width(Dimens.Spacing.Medium)
            )

            Column(
                modifier = Modifier.weight(1F)
            ) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(
                    modifier = Modifier.height(
                        Dimens.Spacing.XXSmall
                    )
                )

                Text(
                    text = product.category,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier.height(
                        Dimens.Spacing.Small
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(
                            Dimens.Size.Icon
                        )
                    )

                    Spacer(
                        modifier = Modifier.width(
                            Dimens.Spacing.XXSmall
                        )
                    )

                    Text(
                        text = "${product.rating.rate} (${product.rating.count})",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(
                    modifier = Modifier.height(
                        Dimens.Spacing.Small
                    )
                )

                Text(
                    text = "£${product.price}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
