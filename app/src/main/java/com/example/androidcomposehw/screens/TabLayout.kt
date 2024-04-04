package com.example.androidcomposehw.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.androidcomposehw.SolutionLeetcode
import com.example.androidcomposehw.data.WeatherModel
import kotlinx.coroutines.launch

const val API_KEY = "ff94238cdf2f4ba28c3123453241803"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(weatherModel: WeatherModel) {
    val tabList = listOf("hours", "days")
    val pagerState = rememberPagerState(pageCount = { tabList.size })
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(start = 3.dp, end = 3.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        TabRow(selectedTabIndex = tabIndex, indicator = { tabPositions ->
            Row(
                modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .height(5.dp)
                        .width(100.dp)
                        .background(color = Color.Blue)
                )
            }
        }) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        SolutionLeetcode().twoSum(intArrayOf(11,2,7,15), 9)
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text)
                    },
                )
            }
        }
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1.0f)) { index ->
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
//                itemsIndexed(listOf(WeatherModel())) { _, item ->
//                    ListItem(weatherModel = item)
//                }
//                items(tabList.size) { index ->
//                    ListItem(w = tabList[index])
//                }
            }
        }
    }
}