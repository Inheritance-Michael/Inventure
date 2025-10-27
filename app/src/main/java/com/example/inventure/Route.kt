package com.example.inventure

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String, val title: String, val icon : Int) {
    object Home : Screen("home", "Home", R.drawable.home)
    object Add : Screen("add", "Add", R.drawable.navadd)
    object Product : Screen("product", "Product", R.drawable.product)
    object Category : Screen("category", "category", R.drawable.category)

}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val screens = listOf(
        Screen.Home,
        Screen.Add,
        Screen.Product,
        Screen.Category
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, screens = screens,)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomePage() }
            composable(Screen.Add.route) {   }
            composable(Screen.Product.route) { Backline() }
            composable(Screen.Category.route) { Background() }
        }
    }
}
