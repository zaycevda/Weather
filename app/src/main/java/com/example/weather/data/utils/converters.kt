package com.example.weather.data.utils

import com.example.weather.data.models.*
import com.example.weather.domain.models.*

fun CurrentWeatherModel.toCurrentWeather() =
    CurrentWeather(
        coord = this.coordModel.toCoord(),
        currentWeatherData = this.currentWeatherDataModel.map { it.toCurrentWeatherData() },
        currentMainData = this.currentMainDataModel.toCurrentMainData(),
        wind = this.windModel.toWind(),
        name = name
    )

private fun CoordModel.toCoord() =
    Coord(
        lon = this.lon,
        lat = this.lat
    )

private fun CurrentWeatherDataModel.toCurrentWeatherData() =
    CurrentWeatherData(
        description = this.description
    )

private fun CurrentMainDataModel.toCurrentMainData() =
    CurrentMainData(
        temp = this.temp,
        feelsLike = this.feelsLike,
        pressure = this.pressure,
        humidity = this.humidity
    )

private fun WindModel.toWind() =
    Wind(speed = this.speed)

fun ForecastWeatherModel.toForecastWeather() =
    ForecastWeather(
        list = this.list.map { it.toData() }
    )

private fun DataModel.toData() =
    Data(
        forecastMainData = this.forecastMainDataModel.toForecastMainData(),
        dateText = this.dateText,
        forecastWeatherData = this.forecastWeatherDataModel.map { it.toForecastWeatherData() }
    )

private fun ForecastMainDataModel.toForecastMainData() =
    ForecastMainData(
        tempMin = this.tempMin,
        tempMax = this.tempMax
    )

private fun ForecastWeatherDataModel.toForecastWeatherData() =
    ForecastWeatherData(
        main = this.main
    )

fun CoordinatesModel.toCoordinates() =
    Coordinates(
        localNames = this.localNamesModel?.toLocalNames(),
        lat = this.lat,
        lon = this.lon
    )

private fun LocalNamesModel.toLocalNames() =
    LocalNames(
        ru = this.ru
    )