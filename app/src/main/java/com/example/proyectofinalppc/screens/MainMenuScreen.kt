package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
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
import kotlin.system.exitProcess

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainMenu(navController: NavController) {
    Scaffold {
        MainMenuBodyContent(navController)
    }
}

@Composable
fun MainMenuBodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Main Menu")
        Button(
            onClick = {
                navController.navigate(route = AppScreens.Element.route)
            }, modifier = Modifier
                .width(300.dp)
                .padding(4.dp),
            shape = CutCornerShape(0)
        ) {
            Text(text = "Join")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                navController.navigate(route = AppScreens.SignIn.route)
            }, modifier = Modifier
                .width(300.dp)
                .padding(4.dp),
            shape = CutCornerShape(0)
        ) {
            Text(text = "Sign in")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                navController.navigate(route = AppScreens.Settings.route)
            }, modifier = Modifier
                .width(300.dp)
                .padding(4.dp),
            shape = CutCornerShape(0)
        )
        {
            Text(text = "Settings")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {/*TODO*/ },
            Modifier
                .width(300.dp)
                .padding(4.dp),
            shape = CutCornerShape(0)
        ) {
            Text(text = "Contact us")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                exitProcess(0)
            },
            shape = CutCornerShape(0)
        ) {
            Text(text = "Exit")
        }
    }
}


