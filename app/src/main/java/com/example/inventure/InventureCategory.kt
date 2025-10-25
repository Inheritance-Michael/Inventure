package com.example.inventure

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BodyBox() {
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
                    listOf(Color(0xFF2196F3), Color(0xFF9C27B0)) // Blue to purple
                )
                "Nature" -> Brush.verticalGradient(
                    listOf(Color(0xFF4CAF50), Color(0xFF81C784)) // Green shades
                )
                "Food" -> Brush.linearGradient(
                    listOf(Color(0xFFFF9800), Color(0xFFFFC107)) // Orange to yellow
                )
                else -> Brush.linearGradient(
                    listOf(Color.Gray, Color.LightGray)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(brush = backgroundBrush, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = category,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Optional: Add overlay text
                Text(
                    text = category,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewUI(){
    BodyBox()
}