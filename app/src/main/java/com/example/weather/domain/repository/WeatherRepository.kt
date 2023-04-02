package com.example.weather.domain.repository

import com.example.weather.domain.models.Coordinates
import com.example.weather.domain.models.CurrentWeather
import com.example.weather.domain.models.ForecastWeather

interface WeatherRepository {

    suspend fun getCurrentWeather(
        lat: Float,
        lon: Float
    ): CurrentWeather?

    suspend fun getForecastWeather(
        lat: Float,
        lon: Float
    ): ForecastWeather?

    suspend fun getCoordinates(city: String): Coordinates?
}