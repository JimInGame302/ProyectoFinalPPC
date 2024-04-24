package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
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
fun SignUp(navController: NavController){
    Scaffold {
        SignUpBody(navController)
    }
}

@Composable
fun SignUpBody(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Sign Up")
        Button(onClick = {
            navController.navigate(route = AppScreens.MainMenu.route)
        }){
            Text(text = "Return")
        }
    }
}