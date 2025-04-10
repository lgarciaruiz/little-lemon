package com.example.littlelemon.composables
import com.example.littlelemon.destinations.Onboarding as OnboardingDestination
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.destinations.Home
import com.example.littlelemon.destinations.Profile
import com.example.littlelemon.screens.Home
import com.example.littlelemon.screens.Onboarding
import com.example.littlelemon.screens.Profile
import com.example.littlelemon.storage.UserPreferences


@Composable
fun NavigationComposable(navController: NavHostController) {
    val userSettings = UserPreferences.getUser(LocalContext.current)
    val startDestination = if (userSettings == null) OnboardingDestination.route else Profile.route

    NavHost(navController = navController, startDestination = startDestination) {
        composable(OnboardingDestination.route){
            Onboarding(navController = navController)
        }
        composable(Home.route){
            Home()
        }
        composable(Profile.route){
            Profile(navHostController = navController)
        }
    }
}