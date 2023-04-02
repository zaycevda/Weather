package com.example.weather.app.utils

import kotlin.math.roundToInt

fun Double.fromKelvinToCelsius() = (this - 273.15).roundToInt()