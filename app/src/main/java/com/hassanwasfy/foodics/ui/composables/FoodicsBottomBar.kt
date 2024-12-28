package com.hassanwasfy.foodics.ui.composables

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hassanwasfy.foodics.R
import com.hassanwasfy.foodics.ui.navigation.BottomNavItem
import com.hassanwasfy.foodics.ui.navigation.Destination

@Composable
fun FoodicsBottomBar(navController: NavController) {
    val bottomNavItems = listOf(
        BottomNavItem(Destination.Products.route, R.drawable.baseline_restaurant_24, "Tables"),
        BottomNavItem(Destination.Orders.route, R.drawable.baseline_menu_book_24, "Orders"),
        BottomNavItem(Destination.AppMenu.route, R.drawable.baseline_restaurant_menu_24, "Menu"),
        BottomNavItem(Destination.Settings.route, R.drawable.baseline_settings_24, "Settings")
    )

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route

    NavigationBar(
        containerColor = Color.White
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                ),
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon), ""
                    )
                },
                label = {
                    Text(
                        item.label
                    )
                }
            )
        }
    }
}
