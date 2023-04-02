package com.example.weather.app.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.app.ui.theme.WhiteAlpha

@Composable
fun CurrentWeatherCardItem(
    title: String,
    data: String,
    unit: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            style = TextStyle(
                color = WhiteAlpha,
                fontSize = 14.sp
            )
        )
        Row(modifier = Modifier.padding(top = 2.dp)) {
            Text(
                text = data,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp
                )
            )
            Text(
                modifier = Modifier.padding(start = 2.dp),
                text = unit,
                style = TextStyle(
                    color = WhiteAlpha,
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun CurrentWeatherCardItemPreview() {
    CurrentWeatherCardItem(
        title = "Скорость ветра",
        data = "4.87",
        unit = "м/с"
    )
}