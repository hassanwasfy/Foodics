package com.hassanwasfy.foodics.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController found!") }


@Composable
fun <T> NavigationHandler(
    effects: Flow<T>,
    handleEffect: (T, NavController) -> Unit
) {
    val navController = LocalNavController.current
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = effects) {
        scope.launch {
            effects.collectLatest { effect ->
                handleEffect(effect, navController)
            }
        }
    }
}