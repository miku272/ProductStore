package com.example.myapplication.features.products.data.mapper

import com.example.myapplication.features.products.data.entities.ProductDto
import com.example.myapplication.features.products.domain.models.Product
import com.example.myapplication.features.products.domain.models.Rating

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        price = price,
        image = image,
        category = category,
        rating = Rating(
            rate = rating.rate,
            count = rating.count
        )
    )
}