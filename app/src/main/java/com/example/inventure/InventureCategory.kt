package com.example.inventure

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun Background(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = ingredientBackground)
    ) {
       Column(
           modifier = modifier
               .padding(15.dp)
       ) {
           Row(
               verticalAlignment = Alignment.CenterVertically,
               modifier = modifier
                   .fillMaxWidth()
           ) {
               Image(
                   painter = painterResource(R.drawable.back),
                   ""
               )
               Text(
                   "Back",
                   fontWeight = FontWeight.SemiBold,
                   fontSize = 22.sp,
               )
           }
       }
        Spacer(modifier = modifier.height(5.dp))

        Column{
            ProductRowUsingForLoop()
        }

        Column {
            CategoryBox()
        }
    }


}

@Composable
fun CategoryBox() {
    val items = listOf(
        Pair(R.drawable.triangle, "Tech"),
        Pair(R.drawable.circle, "Nature"),
        Pair(R.drawable.star, "Food")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items.size) { index ->
            val (imageRes, category) = items[index]

            // Pick color or gradient based on category
            val backgroundBrush = when (category) {
                "Tech" -> Brush.horizontalGradient(
                    listOf(Color(0xFF2196F3), Color(0xFF9C27B0))
                )
                "Nature" -> Brush.verticalGradient(
                    listOf(Color(0xFF4CAF50), Color(0xFF81C784))
                )
                "Food" -> Brush.linearGradient(
                    listOf(Color(0xFFFF9800), Color(0xFFFFC107))
                )
                else -> Brush.linearGradient(
                    listOf(Color.Gray, Color.LightGray)
                )
            }

            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp) // Adjust height as needed
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
//                        .background(
//                            brush = Brush.horizontalGradient(
//                                colors = listOf(
//                                    Color(0xFFFFB74D),
//                                    Color(0xFFFFCC80),
//                                    Color(0xFFE0E0E0)
//                                ),
//
//                                startX = 0.0f,
//                                endX = 1.0f * 1000
//                            )
//                        )
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left Section: Image
                    Image(
                        painter = painterResource(imageRes), // Replace with your actual drawable
                        contentDescription = "Promotion Graphic",
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(end = 8.dp)
                    )

                    // Right Section: Text Content
                    Column(
                        modifier = Modifier.weight(1.5f), // Give more space to text
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "15%",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black // Assuming black text
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = category,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Get discount for every order, only valid for today",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.DarkGray // Lighter grey for description
                            )
                        )

                    }
                }
            }
        }
    }
}


@Composable
fun ProductRowUsingForLoop() {
    val scrollState = rememberScrollState()
    val products = listOf(
        Pair("https://picsum.photos/200", "Apple"),
        Pair("https://picsum.photos/210", "Banana"),
        Pair("https://picsum.photos/220", "Orange"),
        Pair("https://picsum.photos/230", "Mango"),
        Pair("https://picsum.photos/240", "Grapes")
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .padding(horizontal = 16.dp)
    ) {
        for ((index, product) in products.withIndex()) {
            val (imageUrl, name,) = product

            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(end = if (index != products.lastIndex) 16.dp else 0.dp), // spacing
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    // 🖼️ Product Image
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // 📝 Product Text
                    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                        Text(
                            text = name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewUI(){
    Background()
}