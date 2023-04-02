package com.example.weather.data.models

import com.google.gson.annotations.SerializedName

data class CoordinatesModel(
    @SerializedName("local_names")
    val localNamesModel: LocalNamesModel?,
    val lat: Float,
    val lon: Float
)

data class LocalNamesModel(
    val ru: String?
)