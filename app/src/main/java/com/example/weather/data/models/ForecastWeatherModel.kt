package com.example.weather.data.models

import com.google.gson.annotations.SerializedName

data class ForecastWeatherModel(
    val list: List<DataModel>
)

data class DataModel(
    @SerializedName("main")
    val forecastMainDataModel: ForecastMainDataModel,
    @SerializedName("dt_txt")
    val dateText: String,
    @SerializedName("weather")
    val forecastWeatherDataModel: List<ForecastWeatherDataModel>
)

data class ForecastMainDataModel(
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double
)

data class ForecastWeatherDataModel(
    val main: String
)