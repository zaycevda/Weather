package com.example.weather.domain.models

data class ForecastWeather(
    val list: List<Data>
)

data class Data(
    val forecastMainData: ForecastMainData,
    val dateText: String,
    val forecastWeatherData: List<ForecastWeatherData>
)

data class ForecastMainData(
    val tempMin: Double,
    val tempMax: Double
)

data class ForecastWeatherData(
    val main: String
)