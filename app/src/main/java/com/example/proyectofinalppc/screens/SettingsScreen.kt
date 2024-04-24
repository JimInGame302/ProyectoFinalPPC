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
fun SettingsScreen(navController: NavController){
    Scaffold {
        SettingsScreenBody(navController)
    }
}

@Composable
fun SettingsScreenBody(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Settings Screen")
        Button(onClick = {
            navController.navigate(route = AppScreens.MainMenu.route)
        }){
            Text(text = "Return")
        }
    }
}