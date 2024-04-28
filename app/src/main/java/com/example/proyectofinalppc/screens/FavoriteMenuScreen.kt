package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinalppc.R
import com.example.proyectofinalppc.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoriteMenu(navController: NavController) {
    Scaffold {
        FavoriteMenuBodyContent(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteMenuBodyContent(navController: NavController) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var showGrid by remember { mutableStateOf(true) }
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
                showGrid = false
            },
            active = active,
            onActiveChange = {
                active = it
                showGrid = false
            },
            placeholder = { Text(text = "Search a country") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        )
        {
            if (query.isNotEmpty()) {
                val filteredFavorites = countries.filter { it.contains(query, true) }
                FavoriteGridFiltered(
                    navController = navController,
                    filteredFavorites = filteredFavorites
                )
            }
        }
    }
    if (showGrid || query.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FavoriteGrid(navController)
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
        Spacer(modifier = Modifier.width(270.dp))
    }
}

@Composable
fun FavoriteGrid(navController: NavController) {
    val countries = countries
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 96.dp),
        modifier = Modifier
            .height(600.dp)
            .padding(10.dp)
            .border(1.dp, Color.Black)
    ) {
        items(countries) { country ->
            FavoriteItem(onClick = {
                navController.navigate(route = AppScreens.FavoritePlant.route)
            }, painterResource(id = R.drawable.ic_launcher_background), country)
        }
    }
}

@Composable
fun FavoriteGridFiltered(navController: NavController, filteredFavorites: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 96.dp),
        modifier = Modifier
            .height(600.dp)
            .padding(10.dp)
            .border(1.dp, Color.Black)
    ) {
        items(filteredFavorites) { country ->
            FavoriteItem(onClick = {
                navController.navigate(route = AppScreens.FavoritePlant.route)
            }, painterResource(id = R.drawable.ic_launcher_background), country)
        }
    }
}

@Composable
fun FavoriteItem(
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
