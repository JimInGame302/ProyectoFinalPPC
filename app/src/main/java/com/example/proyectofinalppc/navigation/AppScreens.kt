package com.example.proyectofinalppc.navigation

sealed class AppScreens (val route: String) {
    object MainMenu: AppScreens("main_menu")
    object Element: AppScreens("element")
    object FavoriteMenu: AppScreens("favorite_menu")
    object FavoritePlant: AppScreens("favorite_plant")
    object PlantDescription: AppScreens("plant_description")
    object Settings: AppScreens("settings")
    object SignIn: AppScreens("sign_in")
    object SignUp: AppScreens("sign_up")
}