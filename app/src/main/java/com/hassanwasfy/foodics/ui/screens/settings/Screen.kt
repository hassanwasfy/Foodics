package com.hassanwasfy.foodics.ui.screens.settings

import androidx.compose.runtime.Composable
import com.hassanwasfy.foodics.ui.composables.ScreenBase
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenSettings() {
    ScreenBase(
        isLoading = true, isError = false, errorMsg = ""
    ) {}
}