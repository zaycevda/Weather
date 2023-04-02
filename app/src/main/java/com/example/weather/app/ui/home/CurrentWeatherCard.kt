package com.example.weather.app.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.app.ui.theme.Blue
import com.example.weather.app.ui.theme.WhiteAlpha

@Composable
fun CurrentWeatherCard(
    city: String,
    currentTemp: Int,
    description: String,
    feelsLike: Int,
    windSpeed: Double,
    humidity: Int,
    pressure: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Blue,
        shape = RoundedCornerShape(
            bottomStart = 32.dp,
            bottomEnd = 32.dp
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = city,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = "${currentTemp}°",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = description,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "Ощущается как: $feelsLike°",
                style = TextStyle(
                    color = WhiteAlpha,
                    fontSize = 16.sp
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 12.dp,
                        bottom = 32.dp
                    ),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CurrentWeatherCardItem(
                    title = "Скорость ветра",
                    data = windSpeed.toString(),
                    unit = "м/с"
                )
                CurrentWeatherCardItem(
                    title = "Влажность",
                    data = humidity.toString(),
                    unit = "%"
                )
                CurrentWeatherCardItem(
                    title = "Давление",
                    data = pressure.toString(),
                    unit = "гПа"
                )
            }
        }
    }
}

@Preview
@Composable
fun CurrentWeatherCardPreview() {
    CurrentWeatherCard(
        city = "Коломна",
        currentTemp = 5,
        description = "overcast clouds",
        feelsLike = 2,
        windSpeed = 4.87,
        humidity = 80,
        pressure = 1011
    )
}