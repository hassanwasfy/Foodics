package com.hassanwasfy.foodics.ui.screens.orders

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hassanwasfy.foodics.ui.navigation.Destination

fun NavGraphBuilder.addOrderScreenRoute() {
    composable(Destination.Orders.route) { ScreenOrders() }
}

fun NavController.navigateToOrders() {
    navigate(Destination.Orders.route)
}