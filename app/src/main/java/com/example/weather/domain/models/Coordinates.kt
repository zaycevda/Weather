package com.example.weather.domain.models

data class Coordinates(
    val localNames: LocalNames?,
    val lat: Float,
    val lon: Float
)

data class LocalNames(
    val ru: String?
)