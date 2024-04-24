package com.example.proyectofinalppc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinalppc.navigation.AppNavigation
import com.example.proyectofinalppc.navigation.AppScreens

@Composable
fun MainMenu(navController: NavController){
    Scaffold {
        MainMenuBodyContent(navController)
    }
}

@Composable
fun MainMenuBodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Main Menu")
        Button(onClick = {
            navController.navigate(route = AppScreens.Element.route)
        }, modifier = Modifier
            .width(300.dp)
            .padding(4.dp)){
            Text(text = "Join")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.SignIn.route)
        }, modifier = Modifier
            .width(300.dp)
            .padding(4.dp)){
            Text(text = "Sign in")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.Settings.route)
        }, modifier = Modifier
            .width(300.dp)
            .padding(4.dp)){
            Text(text = "Settings")
        }
        Button(onClick = {/*TODO*/},
            Modifier
                .width(300.dp)
                .padding(4.dp)){
            Text(text = "Contact us")
        }
        Button(onClick = {/*TODO*/}){
            Text(text = "Exit")
        }
    }
}


