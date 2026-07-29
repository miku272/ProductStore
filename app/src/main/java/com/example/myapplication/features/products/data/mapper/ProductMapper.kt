package com.example.myapplication.features.products.data.mapper

import com.example.myapplication.features.products.data.entities.ProductDto
import com.example.myapplication.features.products.domain.models.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        price = price,
        image = image
    )
}