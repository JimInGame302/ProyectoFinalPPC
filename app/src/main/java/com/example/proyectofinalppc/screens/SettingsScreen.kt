package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.exponentialDecay
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectofinalppc.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold {
        SettingsScreenBody(navController)
    }
}

@Composable
fun SettingsScreenBody(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Settings",
            style = TextStyle(
                fontSize = 50.sp
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        val languages = listOf("English", "Español")
        Text(text = "Language")
        ComboBox(lista = languages)

        Spacer(modifier = Modifier.height(10.dp))

        var checkedMusic by remember { mutableStateOf(true) }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Music")
            Spacer(modifier = Modifier.width(20.dp))
            Switch(checked = checkedMusic
                , onCheckedChange ={
                    checkedMusic = it
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        var checkedSFX by remember { mutableStateOf(true) }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = "SFX")
            Spacer(modifier = Modifier.width(20.dp))
            Switch(checked = checkedSFX
                , onCheckedChange ={
                    checkedSFX = it
                }
            )
        }

        Spacer(modifier = Modifier.height(150.dp))

        Button(onClick = {
            navController.navigate(route = AppScreens.MainMenu.route)
        },
            shape = CutCornerShape(0)
        ) {
            Text(text = "Menu")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComboBox(lista: List<String>) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var selectedText by remember {
        mutableStateOf(lista[0])
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = !isExpanded
            }
        ) {
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                onValueChange = {
                },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                }
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
                }
            )
            {
                lista.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = {
                            Text(text = text)
                        },
                        onClick = {
                            selectedText = lista[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}