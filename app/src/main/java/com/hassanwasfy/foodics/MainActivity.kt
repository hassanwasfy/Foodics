package com.hassanwasfy.foodics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.hassanwasfy.foodics.ui.navigation.FoodicsApp
import com.hassanwasfy.foodics.ui.theme.FoodicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FoodicsApp(innerPadding)
                }
            }
        }
    }
}