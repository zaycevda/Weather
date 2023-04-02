package com.example.weather.domain.usecases

import com.example.weather.domain.repository.WeatherRepository

class GetForecastWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun execute(
        lat: Float,
        lon: Float
    ) = weatherRepository.getForecastWeather(
        lat = lat,
        lon = lon
    )
}