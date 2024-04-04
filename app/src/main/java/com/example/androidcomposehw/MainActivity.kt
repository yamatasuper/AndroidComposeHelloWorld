package com.example.androidcomposehw

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.androidcomposehw.data.WeatherModel
import com.example.androidcomposehw.screens.API_KEY
import com.example.androidcomposehw.screens.MainCard
import com.example.androidcomposehw.screens.TabLayout
import com.example.androidcomposehw.ui.theme.AndroidComposeHWTheme
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    private var weatherModel by mutableStateOf(WeatherModel("", "", "", "", "", "", "", ""))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeHWTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    getData("Ulyanovsk", applicationContext,
                        { response ->
                            weatherModel = response
                        },
                        { error ->
                            // Handle error if needed
                        }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.weather),
                        contentDescription = "weather",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .alpha(0.5f)
                    )
                    Column {
                        MainCard(weatherModel)
                        TabLayout(weatherModel)
                    }
                }
            }
        }
    }
}

private fun getData(
    city: String,
    context: Context,
    successCallback: (WeatherModel) -> Unit,
    errorCallback: (VolleyError) -> Unit
) {
    val url = "http://api.weatherapi.com/v1/current.json?key=$API_KEY&q=$city&aqi=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(url, { response ->
        val weatherModel = parseResponse(response)
        successCallback(weatherModel)
        Log.d("Api", response)
    }, { error ->
        errorCallback(error)
    })
    queue.add(sRequest)
}

fun parseResponse(response: String): WeatherModel {
    val jsonObject = JSONObject(response)

    val location = jsonObject.getJSONObject("location")
    val city = location.getString("name")

    val current = jsonObject.getJSONObject("current")
    val time = current.getString("last_updated")
    val currentTemp = current.getDouble("temp_c").toString()
    val condition = current.getJSONObject("condition").getString("text")
    val icon = current.getJSONObject("condition").getString("icon")
    val maxTemp = current.getDouble("temp_f").toString()
    val minTemp = current.getDouble("temp_c").toString()
    val hours = current.getInt("is_day")
        .toString() // Предполагается, что это флаг, указывающий на то, день сейчас или нет

    // Создание объекта WeatherModel на основе извлеченных данных
    return WeatherModel(
        city = city,
        time = time,
        currentTemp = currentTemp,
        condition = condition,
        icon = icon,
        maxTemp = maxTemp,
        minTemp = minTemp,
        hours = hours
    )
}