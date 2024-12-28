package com.hassanwasfy.foodics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hassanwasfy.foodics.ui.composables.FoodicsScaffold
import com.hassanwasfy.foodics.ui.theme.FoodicsTheme

val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController found!") }


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodicsTheme {
                val navController = rememberNavController()
                CompositionLocalProvider(LocalNavController provides navController) {
                    FoodicsScaffold(navController)
                }
            }
        }
    }
}