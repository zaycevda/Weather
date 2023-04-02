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
import com.example.weather.app.ui.theme.Gray0
import com.example.weather.app.ui.theme.Gray1
import com.example.weather.app.utils.fromKelvinToCelsius

@Composable
fun ForecastItem(
    date: String,
    tempMin: Double,
    tempMax: Double,
    main: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 18.dp,
                vertical = 12.dp
            ),
        backgroundColor = Gray1,
        shape = RoundedCornerShape(size = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = date.subSequence(5..9).toString(),
                    style = TextStyle(
                        color = Gray0,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = date.subSequence(11..15).toString(),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Температура",
                    style = TextStyle(
                        color = Gray0,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "${((tempMin + tempMax) / 2).fromKelvinToCelsius()}°",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Погода",
                    style = TextStyle(
                        color = Gray0,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = main,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun ForecastItemPreview() {
    ForecastItem(
        date = "2023-03-30 15:00:00",
        tempMin = 277.82,
        tempMax = 279.97,
        main = "Rain"
    )
}