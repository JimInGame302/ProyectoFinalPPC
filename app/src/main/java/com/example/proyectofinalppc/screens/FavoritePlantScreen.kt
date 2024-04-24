package com.example.proyectofinalppc.screens

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
import com.example.proyectofinalppc.navigation.AppScreens

@Composable
fun FavoritePlant(navController: NavController){
    Scaffold {
        FavoritePlantBodyContent(navController)
    }
}

@Composable
fun FavoritePlantBodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Favorite Plant")
        Button(onClick = {
            navController.navigate(route = AppScreens.FavoriteMenu.route)
        }, modifier = Modifier.fillMaxWidth().width(200.dp).padding(16.dp)){
            Text(text = "Return")
        }
    }
}
