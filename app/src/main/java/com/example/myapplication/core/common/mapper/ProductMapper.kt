package com.example.myapplication.core.common.mapper

import com.example.myapplication.core.common.entities.ProductDto
import com.example.myapplication.core.common.models.Product
import com.example.myapplication.core.common.models.Rating

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