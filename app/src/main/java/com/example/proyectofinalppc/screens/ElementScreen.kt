package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinalppc.R
import com.example.proyectofinalppc.data.Plants
import com.example.proyectofinalppc.navigation.AppScreens
import com.example.proyectofinalppc.repository.FirebaseRepository

var curiosities = ""
var fruits = ""
var ground = ""
var height = 0.0F
var image = ""
var maduration = 0.0F
var name = ""
var plantCares = ""
var plantDescription = ""
var scientificName = ""
var weather = ""
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ElementScreen(navController: NavController) {
    Scaffold {
        ElementBodyContent(navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElementBodyContent(navController: NavController) {
    val configuration = LocalConfiguration.current
    val locale = configuration.locales[0]
    val firebaseRepository = FirebaseRepository()
    var plants by remember { mutableStateOf<List<Plants>>(emptyList()) }

    LaunchedEffect(Unit) {
        firebaseRepository.getDocuments { retrievedPlants ->
            plants = retrievedPlants
        }
    }

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            query = query,
            onQueryChange = {
                query = it
            },
            onSearch = {
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder =
            { Text(text = when (locale.language) {
                "en" -> "Search a plant"
                "es" -> "Busca una planta"
                else -> "Search a plant"
            }) },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        )
        {
            if (query.isNotEmpty()) {
                val filteredElements = plants.filter { it.name.contains(query, true) }
                ElementGrid(
                    navController,
                    AppScreens.PlantDescription.route,
                    filteredElements
                )
            }
        }
    }
    if (query.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElementGrid(navController, AppScreens.PlantDescription.route, plants)
        }
    }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                navController.navigate(route = AppScreens.MainMenu.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Transparent,
                contentColor = androidx.compose.ui.graphics.Color.Black
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
                navController.navigate(route = AppScreens.FavoriteMenu.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Transparent,
                contentColor = androidx.compose.ui.graphics.Color.Black
            ),
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
        }
    }
}
@Composable
fun ElementGrid(navController: NavController, route: String, elements: List<Plants>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 96.dp),
        modifier = Modifier
            .height(600.dp)
            .padding(10.dp)
            .border(1.dp, Color.Black)
    ) {
        items(elements) { plant ->
            val imageResId = plant.image.toIntOrNull() ?: R.drawable.arbol
            ElementItem(onClick = {
                navController.navigate(route = route)
                curiosities = plant.curiosities
                fruits = plant.fruits
                ground = plant.ground
                height = plant.height
                image = plant.image
                maduration = plant.maduration
                name = plant.name
                plantCares = plant.plantCares
                plantDescription = plant.plantDescription
                scientificName = plant.scientificName
                weather = plant.weather
            }, painterResource(id = imageResId), plant.name)
        }
    }
}

@Composable
fun ElementItem(
    onClick: () -> Unit,
    imagen: Painter,
    nombre: String,
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imagen,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = nombre,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )
    }
}