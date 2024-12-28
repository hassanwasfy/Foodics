package com.hassanwasfy.foodics.ui.navigation


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.hassanwasfy.foodics.LocalNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FoodicsApp(innerPadding: PaddingValues) {
    val navController = LocalNavController.current
    FoodicsGraph(innerPadding,navController)
}