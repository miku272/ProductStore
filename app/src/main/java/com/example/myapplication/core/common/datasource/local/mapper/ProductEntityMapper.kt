package com.example.myapplication.core.common.datasource.local.mapper

import com.example.myapplication.core.common.datasource.local.entity.ProductEntity
import com.example.myapplication.core.common.domain.models.Product
import com.example.myapplication.core.common.domain.models.Rating

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        image = image,
        rating = Rating(
            rate = ratingRate,
            count = ratingCount
        )
    )
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        image = image,
        ratingRate = rating.rate,
        ratingCount = rating.count
    )
}