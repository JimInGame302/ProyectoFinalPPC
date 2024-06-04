package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinalppc.R
import com.example.proyectofinalppc.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlantDescription(
    navController: NavController,
) {
    Scaffold {
        PlantDescriptionBody(navController)
    }
}

@Composable
fun PlantDescriptionBody(navController: NavController) {
    val configuration = LocalConfiguration.current
    val locale = configuration.locales[0]
    var favorite by remember { mutableStateOf(false) }
    var data by remember { mutableStateOf(TextFieldValue((when (locale.language) {
        "en" -> "Plant description \n" +
                "Plant cares \n" +
                "Curiosities of the plant"
        "es" -> "Descripción de la planta \n" +
                "Cuidados de la planta \n" +
                "Curiosidades de la planta"
        else -> "Plant description \n" +
                "Plant cares \n" +
                "Curiosities of the plant"
    }))) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.arbol),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .border(1.dp, Color.Black)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.height(200.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = when (locale.language) {
                    "en" -> "Name"
                    "es" -> "Nombre"
                    else -> "Name"
                })
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = when (locale.language) {
                    "en" -> "Scientfic name"
                    "es" -> "Nombre científico"
                    else -> "Scientfic name"
                })
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = when (locale.language) {
                    "en" -> "Weather"
                    "es" -> "Clima"
                    else -> "Weather"
                })
                Text(text = when (locale.language) {
                    "en" -> "Ground"
                    "es" -> "Suelo"
                    else -> "Ground"
                })
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value = data,
            onValueChange ={
            },
            readOnly = true,
            modifier = Modifier
                .width(340.dp)
                .height(200.dp)
                .border(1.dp, Color.Black)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.width(340.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Text(text = when (locale.language) {
                "en" -> "Maduration time"
                "es" -> "Tiempo de maduración"
                else -> "Maduration time"
            })

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = when (locale.language) {
                "en" -> "Height"
                "es" -> "Altura"
                else -> "Height"
            })

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = when (locale.language) {
                "en" -> "Fruits"
                "es" -> "Frutos"
                else -> "Fruits"
            })
        }
    }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                navController.navigate(route = AppScreens.Element.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
        ) {
            Icon(painter = painterResource(R.drawable.back), contentDescription = "")
        }

        Spacer(modifier = Modifier.width(200.dp))

        Button(
            onClick = {
                favorite = !favorite
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
        ) {
            if (favorite) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            } else {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
            }
        }
    }
}