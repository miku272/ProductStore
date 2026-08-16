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
import me.nareshsharma.mycamera.MyCameraActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsTopBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    TopAppBar(
        modifier = modifier,
        title = { Text("Products") },
        actions = {
            IconButton(onClick = {
                val intent = Intent(context, MyCameraActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }

            IconButton(onClick = {
                val intent = Intent(context, MyCameraActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorites"
                )
            }
        }
    )
}