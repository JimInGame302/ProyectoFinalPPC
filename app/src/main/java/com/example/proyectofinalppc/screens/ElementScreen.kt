package com.example.proyectofinalppc.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.proyectofinalppc.navigation.AppScreens

@Composable
fun ElementScreen(navController: NavController){
    Scaffold {
        ElementBodyContent(navController)
    }
}

@Composable
fun ElementBodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Element")
        Button(onClick = {
            navController.navigate(route = AppScreens.PlantDescription.route)
        }){
            Text(text = "Plant description")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.FavoriteMenu.route)
        }){
            Text(text = "Favorite Menu")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.MainMenu.route)
        }){
            Text(text = "Return")
        }
    }
}
