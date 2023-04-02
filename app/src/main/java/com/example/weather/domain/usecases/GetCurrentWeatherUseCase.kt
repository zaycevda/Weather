package com.example.weather.domain.usecases

import com.example.weather.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun execute(
        lat: Float,
        lon: Float
    ) = weatherRepository.getCurrentWeather(
        lat = lat,
        lon = lon
    )
}