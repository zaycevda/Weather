package com.example.weather.data.repository

import com.example.weather.data.service.WeatherApi
import com.example.weather.data.utils.showLog
import com.example.weather.data.utils.toCoordinates
import com.example.weather.data.utils.toCurrentWeather
import com.example.weather.data.utils.toForecastWeather
import com.example.weather.domain.models.*
import com.example.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.Exception

class WeatherRepositoryImpl(private val weatherApi: WeatherApi) : WeatherRepository {

    override suspend fun getCurrentWeather(
        lat: Float,
        lon: Float
    ) = withContext(Dispatchers.IO) {

        var currentWeather: CurrentWeather? = null

        try {
            val currentWeatherModel = weatherApi.getCurrentWeather(
                lat = lat,
                lon = lon
            )
            showLog("Repository current model: $currentWeatherModel")
            currentWeather = currentWeatherModel.toCurrentWeather()
        } catch (e: Exception) {
            showLog(e.message.toString())
        }

//        showLog("Repository current: $currentWeather")
        return@withContext currentWeather
    }

    override suspend fun getForecastWeather(
        lat: Float,
        lon: Float
    ) = withContext(Dispatchers.IO) {

        var forecastWeather: ForecastWeather? = null

        try {
            val forecastWeatherModel = weatherApi.getForecastWeather(
                lat = lat,
                lon = lon
            )
            showLog("Repository forecast model: $forecastWeatherModel")
            forecastWeather = forecastWeatherModel.toForecastWeather()
        } catch (e: Exception) {
            showLog(e.message.toString())
        }

//        showLog("Repository forecast: $forecastWeather")
        return@withContext forecastWeather
    }

    override suspend fun getCoordinates(city: String) = withContext(Dispatchers.IO) {

        var coordinates: Coordinates? = null

        try {
            val coordinatesModel = weatherApi.getCoordinates(city = city)[0]
            showLog("Repository coordinates model: $coordinatesModel")
            coordinates = coordinatesModel.toCoordinates()
        } catch (e: Exception) {
            showLog(e.message.toString())
        }

//        showLog("Repository coordinates: $coordinates")
        return@withContext coordinates
    }
}