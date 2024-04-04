package com.example.androidcomposehw.syntax//package com.example.androidcomposehw
//
//import android.app.LauncherActivity.ListItem
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CardElevation
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.androidcomposehw.ui.theme.AndroidComposeHWTheme
//
//class MainActivityHW : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AndroidComposeHWTheme {
//                // A surface container using the 'background' color from the theme
////                Surface(
////                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
////                ) {
//                Greeting("Android")
////                }
//            }
//        }
//    }
//}
//
////@Preview(showBackground = true)
////@Composable
////fun GreetingPreview() {
////    AndroidComposeHWTheme {
////        Greeting("Android")
////    }
////}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    LazyColumn() {
////        items(count = 2) {
////            Text(
////                text = "lazy item it $it",
////                modifier = modifier,
////                textAlign = TextAlign.Center,
////            )
////        }
//        // В стандартном Android UI есть компонент RecyclerView, который переиспользует отдельные элементы списка по мере необходимости, подставляя новые данные в момент видимости и убирая лишнее, когда отображение данных уходит за пределы экрана. Подобное поведение в Compose называется ленивой загрузкой (lazy loading).
//        //
//        //Если в RecyclerView был LayoutManager, который позволял создать горизонтальную и вертикальную прокрутку списка, то в Compose существуют две отдельные функции LazyColumn и LazyRow. При этом нет нужды создавать ViewHolder, так как принцип композиции в Compose сам берёт на себя эту задачу.
//        itemsIndexed(listOf("item1", "item2", "end")) { index, item ->
//            Text(
//                text = "lazy item $item index $index",
//                modifier = modifier,
//                textAlign = TextAlign.Center,
//            )
//        }
//    }
////    Column(
////        horizontalAlignment = Alignment.CenterHorizontally,
////        modifier = Modifier
////            .fillMaxSize()
////            .verticalScroll(rememberScrollState()),
////    ) {
////        Row(
////            modifier = Modifier
////                .background(Color.Green)
////                .fillMaxWidth(),
////            horizontalArrangement = Arrangement.SpaceBetween
////        ) {
////            Text(
////                text = "Hello 1 $name!",
////                modifier = modifier,
////                textAlign = TextAlign.Center,
////            )
////            Text(
////                text = "Hello 2 $name!",
////                modifier = modifier,
////                textAlign = TextAlign.Center,
////            )
////        }
////        for (i in 0..15) {
////            CardItem("$i", "IT")
////        }
////    }
//}
//
//@Composable
//private fun CardItem(name: String, prof: String) {
//    val counter = remember {
//        mutableIntStateOf(0)
//    }
//    val color = remember {
//        mutableStateOf(Color.Green)
//    }
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//            .offset(5.dp, 5.dp)
//            .pointerInput(Unit) {
//                detectDragGesturesAfterLongPress { change, dragAmount ->
//                    Log.d(
//                        "asd2", "$change, $dragAmount"
//                    )
//                }
//            }
//            .clickable {
//                Log.d("asd", "card clicked")
//                counter.intValue++
//                if (color.value != Color.Blue) {
//                    color.value = Color.Blue
//                } else {
//                    color.value = Color.Green
//                }
//                when (
//                    counter.intValue
//                ) {
//                    5 -> counter.intValue = 0
//                }
//            },
//        shape = RoundedCornerShape(15.dp),
//        elevation = CardDefaults.cardElevation(5.dp),
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(color.value, shape = CircleShape),
//            contentAlignment = Alignment.Center
//        ) {
//            Row {
//                Image(
//                    painter = painterResource(id = R.drawable.image),
//                    contentDescription = "image",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(64.dp)
//                        .clip(CircleShape)
//                        .padding(5.dp)
//                )
//                Text(
//                    text = name,
//                )
//                Text(text = counter.intValue.toString())
//            }
//        }
//    }
//}