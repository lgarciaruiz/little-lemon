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
import com.example.littlelemon.storage.MenuItemRoom
import com.example.littlelemon.storage.UserPreferences


@Composable
fun NavigationComposable(navHostController: NavHostController, menuItems: List<MenuItemRoom>) {
    val userSettings = UserPreferences.getUser(LocalContext.current)
    val startDestination = if (userSettings == null) OnboardingDestination.route else Home.route

    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(OnboardingDestination.route){
            Onboarding(navHostController = navHostController)
        }
        composable(Home.route){
            Home(navHostController = navHostController, menuItems = menuItems)
        }
        composable(Profile.route){
            Profile(navHostController = navHostController)
        }
    }
}