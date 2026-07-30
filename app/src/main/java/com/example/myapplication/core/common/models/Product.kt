package com.example.myapplication.core.common.models

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val category: String,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)