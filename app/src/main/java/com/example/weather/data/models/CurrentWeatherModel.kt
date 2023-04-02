package com.example.weather.data.models

import com.google.gson.annotations.SerializedName

data class CurrentWeatherModel(
    @SerializedName("coord")
    val coordModel: CoordModel,
    @SerializedName("weather")
    val currentWeatherDataModel: List<CurrentWeatherDataModel>,
    @SerializedName("main")
    val currentMainDataModel: CurrentMainDataModel,
    @SerializedName("wind")
    val windModel: WindModel,
    val name: String
)

data class CoordModel(
    val lon: Double,
    val lat: Double
)

data class CurrentWeatherDataModel(
    val description: String
)

data class CurrentMainDataModel(
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int
)

data class WindModel(
    val speed: Double
)