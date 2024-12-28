package com.hassanwasfy.foodics.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.hassanwasfy.foodics.ui.navigation.FoodicsApp


@Composable
fun FoodicsScaffold(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { FoodicsBottomBar(navController) }) { innerPadding ->
        FoodicsApp(innerPadding)
    }
}