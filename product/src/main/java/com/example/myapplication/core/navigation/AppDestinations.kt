package com.example.myapplication.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Products

@Serializable
data class Details(
    val productId: Int
)

@Serializable
object Favorites

@Serializable
object Settings