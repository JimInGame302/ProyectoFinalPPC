package com.example.proyectofinalppc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinalppc.screens.ElementScreen
import com.example.proyectofinalppc.screens.FavoriteMenu
import com.example.proyectofinalppc.screens.FavoritePlant
import com.example.proyectofinalppc.screens.MainMenu
import com.example.proyectofinalppc.screens.PlantDescription
import com.example.proyectofinalppc.screens.SettingsScreen
import com.example.proyectofinalppc.screens.SignIn
import com.example.proyectofinalppc.screens.SignUp

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.MainMenu.route) {
        composable(route=AppScreens.MainMenu.route){
            MainMenu(navController)
        }
        composable(route=AppScreens.Element.route){
            ElementScreen(navController)
        }
        composable(route=AppScreens.FavoriteMenu.route){
            FavoriteMenu(navController)
        }
        composable(route=AppScreens.FavoritePlant.route){
           FavoritePlant(navController)
        }
        composable(route=AppScreens.PlantDescription.route){
            PlantDescription(navController)
        }
        composable(route=AppScreens.Settings.route){
            SettingsScreen(navController)
        }
        composable(route=AppScreens.SignIn.route){
            SignIn(navController)
        }
        composable(route=AppScreens.SignUp.route){
            SignUp(navController)
        }
    }
}