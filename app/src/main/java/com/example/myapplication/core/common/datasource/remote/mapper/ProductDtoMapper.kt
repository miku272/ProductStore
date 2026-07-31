package com.example.myapplication.core.common.datasource.remote.mapper

import com.example.myapplication.core.common.datasource.local.entity.ProductEntity
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

fun ProductDto.toEntity(): ProductEntity {

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