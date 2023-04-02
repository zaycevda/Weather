package com.example.weather.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.utils.showLog
import com.example.weather.domain.models.Coordinates
import com.example.weather.domain.models.CurrentWeather
import com.example.weather.domain.models.ForecastWeather
import com.example.weather.domain.usecases.GetCoordinatesUseCase
import com.example.weather.domain.usecases.GetCurrentWeatherUseCase
import com.example.weather.domain.usecases.GetForecastWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase,
    private val getCoordinatesUseCase: GetCoordinatesUseCase
) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _currentWeather = MutableStateFlow<CurrentWeather?>(null)
    val currentWeather = _currentWeather.asStateFlow()

    fun getCurrentWeather(
        lat: Float,
        lon: Float
    ) {
        viewModelScope.launch {
            val currentWeather = getCurrentWeatherUseCase.execute(
                    lat = lat,
                    lon = lon
                )
//            showLog("view model current: $currentWeather")
            _currentWeather.value = currentWeather
        }
    }

    private val _forecastWeather = MutableStateFlow<ForecastWeather?>(null)
    val forecastWeather = _forecastWeather.asStateFlow()

    fun getForecastWeather(
        lat: Float,
        lon: Float
    ) {
        viewModelScope.launch {
            val forecastWeather = getForecastWeatherUseCase.execute(
                lat = lat,
                lon = lon
            )
//            showLog("view model forecast: $forecastWeather")
            _forecastWeather.value = forecastWeather
        }
    }

    private val _coordinates = MutableStateFlow<Coordinates?>(null)
    val coordinates = _coordinates.asStateFlow()

    fun getCoordinates(city: String) {
        viewModelScope.launch {
            _loading.value = true
            val coordinates = getCoordinatesUseCase.execute(city = city)
//            showLog("view model coordinates: $coordinates")
            _coordinates.value = coordinates
            _loading.value = false
        }
    }
}