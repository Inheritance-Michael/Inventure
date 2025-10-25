package com.example.inventure

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


data class Item(
    val imageUrl: String,
    val description: String,
    val price: String,
    val quantity: String
)



@Composable
fun AddItemScreen(viewModel: ItemViewModel, onDone: () -> Unit) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var desc by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var qty by remember { mutableStateOf("") }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Add New Item", style = MaterialTheme.typography.titleLarge)

        // Image Preview Box
        Box(
            modifier = Modifier
                .size(120.dp)
                .clickable { launcher.launch("image/*") },
            contentAlignment = Alignment.Center
        ) {
            if (imageUri != null) {
                AsyncImage(
                    model = imageUri,
                    contentDescription = "Selected Image",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text("Tap to select image", color = Color.Gray)
            }
        }

        OutlinedTextField(value = desc, onValueChange = { desc = it }, label = { Text("Description") })
        OutlinedTextField(value = price, onValueChange = { price = it }, label = { Text("Price") })
        OutlinedTextField(value = qty, onValueChange = { qty = it }, label = { Text("Quantity") })

        Button(
            onClick = {
                if (imageUri != null && desc.isNotBlank()) {
                    viewModel.addItem(
                        Item(
                            imageUrl = imageUri.toString(),
                            description = desc,
                            price = price,
                            quantity = qty
                        )
                    )
                    onDone()
                }
            }
        ) {
            Text("Save Item")
        }
    }
}



