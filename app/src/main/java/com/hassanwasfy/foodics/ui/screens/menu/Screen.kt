package com.hassanwasfy.foodics.ui.screens.menu

import androidx.compose.runtime.Composable
import com.hassanwasfy.foodics.ui.composables.ScreenBase
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenMenu(){
    ScreenBase(
        isLoading = true, isError = false, errorMsg = ""
    ) {}
}