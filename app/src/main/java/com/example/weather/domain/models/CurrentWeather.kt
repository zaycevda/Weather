package com.example.weather.domain.models

data class CurrentWeather(
    val coord: Coord,
    val currentWeatherData: List<CurrentWeatherData>,
    val currentMainData: CurrentMainData,
    val wind: Wind,
    val name: String
)

data class Coord(
    val lon: Double,
    val lat: Double
)

data class CurrentWeatherData(
    val description: String
)

data class CurrentMainData(
    val temp: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Double
)