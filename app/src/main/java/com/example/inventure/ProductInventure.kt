package com.example.inventure

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun Backline(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = ingredientBackground)
    ) {
        ShopScreen()
    }
}


@Composable
fun ShopProductCard(
    imageUrl: String,
    name: String,
    price: String,
    modifier: Modifier = Modifier,
    onAddToCartClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(170.dp)
            .height(210.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = price,
                        fontSize = 15.sp,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.SemiBold
                    )

                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = modifier
                            .clickable{}
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.more),
                            "",
                        )
                    }
                }


                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = modifier
                            .size(50.dp)
                            .width(70.dp)
                            .background(Color(0xffd3d3d3), RoundedCornerShape(15.dp))
                            .clickable{},
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(R.drawable.edit),
                            ""
                        )
                    }

                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        Arrangement.End,
                    ) {
                        Box(
                            modifier = modifier
                                .size(50.dp)
                                .width(70.dp)
                                .background(Color(0x80FF0000), RoundedCornerShape(15.dp))
                                .clickable{},
                            contentAlignment = Alignment.Center
                        ){
                            Image(
                                painter = painterResource(R.drawable.delete),
                                ""
                            )
                        }
                    }

                }

            }
        }
    }
}


@Composable
fun ShopScreen() {
    val products = listOf(
        Triple("https://picsum.photos/200", "Apples", "₦2,000"),
        Triple("https://picsum.photos/210", "Bananas", "₦1,500"),
        Triple("https://picsum.photos/220", "Oranges", "₦2,200"),
        Triple("https://picsum.photos/230", "Mangoes", "₦1,800"),
        Triple("https://picsum.photos/240", "Grapes", "₦3,500"),
        Triple("https://picsum.photos/250", "Pineapples", "₦2,800")
    )

    Column{

        // 🧱 Product Grid
        for (rowItems in products.chunked(2)) { // 🔥 creates 2 cards per row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for ((image, name, price) in rowItems) {
                    ShopProductCard(
                        imageUrl = image,
                        name = name,
                        price = price,
                        onAddToCartClick = {
                            // handle Add button click
                        }
                    )
                }
            }
        }

    }
}