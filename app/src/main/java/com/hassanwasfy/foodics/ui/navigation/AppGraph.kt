package com.hassanwasfy.foodics.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost


@Composable
fun FoodicsGraph(innerPadding: PaddingValues) {
    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        navController = LocalNavController.current,
        startDestination = Destination.Tables.route
    ) {

    }
}

sealed class Destination(val route: String) {
    data object Tables : Destination("Tables")
    data object Orders : Destination("Orders")
    data object AppMenu : Destination("AppMenu")
    data object Settings : Destination("Settings")
}