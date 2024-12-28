package com.hassanwasfy.foodics.ui.screens.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hassanwasfy.foodics.ui.navigation.Destination

fun NavGraphBuilder.addSettingsScreenRoute() {
    composable(Destination.Settings.route) { ScreenSettings() }
}

fun NavController.navigateToSettings() {
    navigate(Destination.Settings.route)
}