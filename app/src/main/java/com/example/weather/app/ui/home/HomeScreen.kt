package com.example.weather.app.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.app.ui.search.SearchDialog
import com.example.weather.app.ui.theme.Gray2
import com.example.weather.domain.models.Data
import com.example.weather.domain.models.ForecastMainData
import com.example.weather.domain.models.ForecastWeatherData

@Composable
fun HomeScreen(
    search: (String) -> Unit,
    loadingProgressBar: Boolean,
    city: String,
    currentTemp: Int,
    description: String,
    feelsLike: Int,
    windSpeed: Double,
    humidity: Int,
    pressure: Int,
    listData: List<Data>
) {
    var isDialogShown by remember { mutableStateOf(false) }
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray2)
    ) {
        item {
            CurrentWeatherCard(
                city = city,
                currentTemp = currentTemp,
                description = description,
                feelsLike = feelsLike,
                windSpeed = windSpeed,
                humidity = humidity,
                pressure = pressure
            )
            CircularProgressBar(isDisplayed = loadingProgressBar)
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Температура на 5 дней",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                IconButton(onClick = { isDialogShown = true }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        tint = Color.White,
                        contentDescription = "Search"
                    )
                }
            }
        }
        items(listData) { currentData ->
            ForecastItem(
                date = currentData.dateText,
                tempMin = currentData.forecastMainData.tempMin,
                tempMax = currentData.forecastMainData.tempMax,
                main = currentData.forecastWeatherData[0].main
            )
        }
    }
    if (isDialogShown) {
        SearchDialog(
            onDismiss = {
                isDialogShown = false
            },
            onConfirm = {
                search(it)
                isDialogShown = false
            }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val data = Data(
        forecastMainData = ForecastMainData(
            tempMin = 277.82,
            tempMax = 282.82
        ),
        dateText = "2023-03-30 15:00:00",
        forecastWeatherData = listOf(
            ForecastWeatherData(
                main = "Clouds"
            )
        )
    )
    val listData =
        listOf(data, data, data, data, data, data, data, data, data, data, data, data, data, data)
    HomeScreen(
        search = {},
        loadingProgressBar = true,
        city = "Коломна",
        currentTemp = 5,
        description = "overcast clouds",
        feelsLike = 2,
        windSpeed = 4.87,
        humidity = 80,
        pressure = 1011,
        listData = listData
    )
}