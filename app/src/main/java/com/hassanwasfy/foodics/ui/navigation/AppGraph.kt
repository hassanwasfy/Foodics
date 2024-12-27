package com.hassanwasfy.foodics.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.hassanwasfy.foodics.ui.screens.menu.addMenuScreenRoute
import com.hassanwasfy.foodics.ui.screens.orders.addOrderScreenRoute
import com.hassanwasfy.foodics.ui.screens.products.addProductsScreenRoute
import com.hassanwasfy.foodics.ui.screens.settings.addSettingsScreenRoute


@Composable
fun FoodicsGraph(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        navController = navController,
        startDestination = Destination.Products.route
    ) {
        addProductsScreenRoute()
        addMenuScreenRoute()
        addOrderScreenRoute()
        addSettingsScreenRoute()
    }
}

sealed class Destination(val route: String) {
    data object Products : Destination("Products")
    data object Orders : Destination("Orders")
    data object AppMenu : Destination("AppMenu")
    data object Settings : Destination("Settings")
}