package com.hassanwasfy.foodics.ui.screens.orders

import androidx.compose.runtime.Composable
import com.hassanwasfy.foodics.ui.composables.ScreenBase
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenOrders(){
    ScreenBase(
        isLoading = true, isError = false, errorMsg = ""
    ) {}
}