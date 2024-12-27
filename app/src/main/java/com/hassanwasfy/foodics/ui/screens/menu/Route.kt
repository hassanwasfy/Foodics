package com.hassanwasfy.foodics.ui.screens.menu

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hassanwasfy.foodics.ui.navigation.Destination

fun NavGraphBuilder.addMenuScreenRoute() {
    composable(Destination.AppMenu.route) { ScreenMenu() }
}

fun NavController.navigateToMenu() {
    navigate(Destination.AppMenu.route)
}