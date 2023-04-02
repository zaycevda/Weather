package com.example.weather.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather.domain.usecases.GetCoordinatesUseCase
import com.example.weather.domain.usecases.GetCurrentWeatherUseCase
import com.example.weather.domain.usecases.GetForecastWeatherUseCase

class WeatherViewModelFactory(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase,
    private val getCoordinatesUseCase: GetCoordinatesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        WeatherViewModel(
            getCurrentWeatherUseCase = getCurrentWeatherUseCase,
            getForecastWeatherUseCase = getForecastWeatherUseCase,
            getCoordinatesUseCase = getCoordinatesUseCase
        ) as? T ?: throw IllegalArgumentException("WeatherViewModel Not Found")
}