package com.example.weather.domain.usecases

import com.example.weather.domain.repository.WeatherRepository

class GetCoordinatesUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun execute(city: String) = weatherRepository.getCoordinates(city = city)
}