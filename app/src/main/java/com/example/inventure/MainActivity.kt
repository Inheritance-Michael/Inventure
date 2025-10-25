package com.example.inventure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inventure.ui.theme.InventureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun BottomNav(modifier: Modifier = Modifier){
    Row {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            NavigationBar(
                containerColor = Color(0x00FFFFFF),
            ) {
                NavigationBarItem(
                    onClick = {},
                    icon ={
                        Icon(
                            painter = painterResource(R.drawable.home),
                            "Home Icon",
                            modifier = Modifier
                                .size(40.dp)
                        )
                    },
                    selected = false
                )

                NavigationBarItem(
                    onClick = {},
                    icon ={
                        Icon(
                            painter = painterResource(R.drawable.navadd),
                            "Home Icon",
                            modifier = Modifier
                                .size(40.dp)
                        )
                    },
                    selected = false
                )

                NavigationBarItem(
                    onClick = {},
                    icon ={
                        Icon(
                            painter = painterResource(R.drawable.product),
                            "Home Icon",
                            modifier = Modifier
                                .size(40.dp)
                        )
                    },
                    selected = false
                )

                NavigationBarItem(
                    onClick = {},
                    icon ={
                        Icon(
                            painter = painterResource(R.drawable.category),
                            "Home Icon",
                            modifier = Modifier
                                .size(40.dp)
                        )
                    },
                    selected = false
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomNav()
}