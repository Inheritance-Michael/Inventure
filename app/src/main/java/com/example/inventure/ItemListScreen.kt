package com.example.inventure



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun ItemListScreen(
    viewModel: ItemViewModel,
    modifier: Modifier = Modifier
) {
    val items = viewModel.items

    if (items.isEmpty()) {
        // Empty screen text
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No items added yet", color = Color.Gray)
        }
    } else {
        // List of items
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items) { item ->
                ItemCard(item)
            }
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.description,
                modifier = Modifier
                    .size(80.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "₦${item.price}",
                    color = Color(0xFF4CAF50),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Qty: ${item.quantity}",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun InventoryApp() {
    val navController = rememberNavController()
    val viewModel: ItemViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "list" // 👈 Start from the list screen
    ) {
        // 🧾 List Screen
        composable("list") {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = { navController.navigate("add") }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
            ) { padding ->
                ItemListScreen(
                    viewModel = viewModel,
                    modifier = Modifier.padding(padding)
                )
            }
        }

        // ➕ Add Item Screen
        composable("add") {
            AddItemScreen(
                viewModel = viewModel,
                onDone = { navController.popBackStack() } // go back after adding
            )
        }
    }
}
