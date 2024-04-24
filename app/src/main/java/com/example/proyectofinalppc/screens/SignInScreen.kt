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
fun SignIn(navController: NavController){
    Scaffold {
        SignInBody(navController)
    }
}

@Composable
fun SignInBody(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Sign In")
        Button(onClick = {
            navController.navigate(route = AppScreens.SignUp.route)
        }){
            Text(text = "Sign up")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.MainMenu.route)
        }){
            Text(text = "Return")
        }
    }
}
