package com.example.weather.data.service

import com.example.weather.data.models.CoordinatesModel
import com.example.weather.data.models.CurrentWeatherModel
import com.example.weather.data.models.ForecastWeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather?&&appid=$API_KEY")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ): CurrentWeatherModel

    @GET("data/2.5/forecast?&&appid=$API_KEY")
    suspend fun getForecastWeather(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ): ForecastWeatherModel

    @GET("geo/1.0/direct?&limit=5&appid=$API_KEY")
    suspend fun getCoordinates(@Query("q") city: String): List<CoordinatesModel>

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val API_KEY = "b9dd1a63832200fe31071339aab15ffb"
    }
}