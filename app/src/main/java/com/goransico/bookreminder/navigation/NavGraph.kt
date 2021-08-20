package com.goransico.bookreminder.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.goransico.bookreminder.MainNavRoutes
import com.goransico.bookreminder.MainViewModel
import com.goransico.bookreminder.presentation.MainScreen

@Composable
fun NavGraph(viewModel: MainViewModel) {

    val navController = rememberNavController()

    ProvideWindowInsets {
        NavHost(
            navController = navController,
            startDestination = MainNavRoutes.MainScreen
        ) {
            Log.d("MainScreen", "1")
            composable(route = MainNavRoutes.MainScreen) {
                MainScreen(viewModel)
            }
        }
    }
}
