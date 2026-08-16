package com.example.myapplication.features.products.presentation.composables

import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.myapplication.R
import me.nareshsharma.mycamera.MyCameraActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsTopBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    TopAppBar(
        modifier = modifier,
        title = { Text(stringResource(R.string.products_title)) },
        actions = {
            IconButton(onClick = {
                val intent = Intent(context, MyCameraActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_content_description)
                )
            }

            IconButton(onClick = {
                val intent = Intent(context, MyCameraActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(R.string.favorites_content_description)
                )
            }
        }
    )
}