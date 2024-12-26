package com.hassanwasfy.foodics.ui.navigation


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FoodicsApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        FoodicsGraph(innerPadding)
    }
}