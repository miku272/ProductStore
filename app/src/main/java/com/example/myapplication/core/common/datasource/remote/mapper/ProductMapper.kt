package com.example.myapplication.core.common.datasource.remote.mapper

import com.example.myapplication.core.common.datasource.remote.entities.ProductDto
import com.example.myapplication.core.common.domain.models.Product
import com.example.myapplication.core.common.domain.models.Rating

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        price = price,
        description = description,
        image = image,
        category = category,
        rating = Rating(
            rate = rating.rate,
            count = rating.count
        )
    )
}