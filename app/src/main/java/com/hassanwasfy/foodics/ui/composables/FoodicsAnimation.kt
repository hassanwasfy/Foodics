package com.hassanwasfy.foodics.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable


@Composable
fun FoodicsAnimation(status: Boolean, content: @Composable () -> Unit) {
    AnimatedVisibility(
        status,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        content()
    }
}