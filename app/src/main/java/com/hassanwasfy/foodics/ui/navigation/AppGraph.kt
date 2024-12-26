package com.hassanwasfy.foodics.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost


@Composable
fun MoneyEyeNavGraph() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = Destination.Tables.route
    ) {
        
    }
}

sealed class Destination(val route: String) {
    data object Tables: Destination("Tables")
    data object Orders : Destination("Orders")
    data object AppMenu : Destination("AppMenu")
    data object Settings : Destination("Settings")
}