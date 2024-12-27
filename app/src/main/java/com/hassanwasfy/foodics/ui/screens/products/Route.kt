package com.hassanwasfy.foodics.ui.screens.products

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hassanwasfy.foodics.ui.navigation.Destination

fun NavGraphBuilder.addProductsScreenRoute() {
    composable(Destination.Products.route) { ScreenProducts() }
}

fun NavController.navigateToProducts() {
    navigate(Destination.Products.route)
}