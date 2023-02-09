package com.lyrjie.bloodysimpletracker.components.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lyrjie.bloodysimpletracker.components.ui.screens.home.LoginScreen
import com.lyrjie.bloodysimpletracker.components.ui.screens.login.HomeScreen

@Composable
fun TrackerNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.LOGIN.route) {
        composable(Screens.HOME.route) { HomeScreen() }
        composable(Screens.LOGIN.route) {
            LoginScreen(
                showHome = { navController.navigate(Screens.HOME.route) }
            )
        }
    }
}
