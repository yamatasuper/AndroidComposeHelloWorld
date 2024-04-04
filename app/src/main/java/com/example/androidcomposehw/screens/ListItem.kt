package com.example.androidcomposehw.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.androidcomposehw.data.WeatherModel

@Composable
fun ListItem(weatherModel: WeatherModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(start = 8.dp, top = 5.dp, bottom = 5.dp),
            ) {
                Text(text = weatherModel.city)
                Text(text = weatherModel.condition)
            }
            Text(text = weatherModel.currentTemp.ifEmpty { "empty" })
            AsyncImage(
                model = "https:${weatherModel.icon}",
                contentDescription = "imageApi",
                modifier = Modifier
                    .size(35.dp)
                    .padding(top = 3.dp, end = 8.dp),
            )
        }
    }
}