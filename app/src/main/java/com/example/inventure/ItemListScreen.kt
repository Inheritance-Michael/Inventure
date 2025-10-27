package com.example.inventure


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage


// --------------------- PRODUCT CARD (YOUR DESIGN) ---------------------
@Composable
fun ProductCard(
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
            .height(200.dp),
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
                            .clickable { }
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.more),
                            contentDescription = ""
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
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.edit),
                            contentDescription = ""
                        )
                    }

                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Box(
                            modifier = modifier
                                .size(50.dp)
                                .width(70.dp)
                                .background(Color(0x80FF0000), RoundedCornerShape(15.dp))
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.delete),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
    }
}


// --------------------- ITEM LIST SCREEN ---------------------
@Composable
fun ItemListScreen(viewModel: ItemViewModel) {
    val items = viewModel.items

    if (items.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No items added yet", color = Color.Gray)
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items.chunked(2).forEach { rowItems ->
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        for (item in rowItems) {
                            ProductCard(
                                imageUrl = item.imageUrl,
                                name = item.description,
                                price = "₦${item.price}",
                                onAddToCartClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}

// --------------------- MAIN APP NAVIGATION ---------------------
//@Composable
//fun InventoryApp() {
//    val navController = rememberNavController()
//    val viewModel: ItemViewModel = viewModel()
//
//    NavHost(navController = navController, startDestination = "list") {
//        // 🏠 List Screen
//        composable("list") {
//            Scaffold(
//                floatingActionButton = {
//                    FloatingActionButton(onClick = { navController.navigate("add") }) {
//                        Icon(Icons.Default.Add, contentDescription = "Add")
//                    }
//                }
//            ) { padding ->
//                Box(modifier = Modifier.padding(padding)) {
//                    ItemListScreen(viewModel)
//                }
//            }
//        }
//
//        // ➕ Add Item Screen
//        composable("add") {
//            AddItemScreen(
//                viewModel = viewModel,
//                onDone = { navController.navigate("add/") }
//            )
//        }
//    }
//}
