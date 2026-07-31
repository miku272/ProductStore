package com.example.myapplication.core.common.datasource.remote.entities

import kotlinx.serialization.Serializable

@Serializable
data class RatingDto(
    val rate: Double,
    val count: Int
)
