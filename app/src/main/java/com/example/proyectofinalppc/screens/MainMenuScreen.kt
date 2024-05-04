package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinalppc.navigation.AppNavigation
import com.example.proyectofinalppc.navigation.AppScreens
import kotlin.system.exitProcess

var language: String = "English";
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainMenu(navController: NavController) {
    Scaffold {
        MainMenuBodyContent(navController)
    }
}

@Composable
fun MainMenuBodyContent(navController: NavController) {
    var openAlertDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(if (language=="Español")"Menu principal" else "Main Menu")
        Button(
            onClick = {
                navController.navigate(route = AppScreens.Element.route)
            }, modifier = Modifier
                .width(300.dp)
                .padding(4.dp),
            shape = CutCornerShape(0)
        ) {
            Text(text = if (language=="Español")"Ingresar" else "Join")
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
            Text(text = if (language=="Español")"Iniciar sesión" else "Sign in")
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
            Text(text = if (language=="Español")"Configuración" else "Settings")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                openAlertDialog = true
            },
            Modifier
                .width(300.dp)
                .padding(4.dp),
            shape = CutCornerShape(0)
        ) {
            Text(text = if (language=="Español")"Contactanos" else "Contact us")
            if (openAlertDialog) {
                AlertDialogApp(
                    onDismissRequest = {
                    },
                    onConfirmation = {
                        openAlertDialog = false
                    },
                    dialogTitle = if (language=="Español")"LINKS DE CONTACTO" else "CONTACT LINKS",
                    dialogText = if (language=="Español")"Correo electronico\n" +
                            "Número telefónico\n" +
                            "Link de ubicación" else "Email\n" +
                            "Phone number\n" +
                            "Ubication link",
                    icon = Icons.Default.Call,
                    url = "https://www.linkedin.com/in/jimmy-saavedra-912062290/"
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                exitProcess(0)
            },
            shape = CutCornerShape(0)
        ) {
            Text(text = if (language=="Español")"Salir" else "Exit")
        }
    }
}

@Composable
fun AlertDialogApp(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
    url: String,
) {
    val openUrlLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = null)
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
            Row(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = "Linkedin",
                    style = TextStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier
                        .clickable(onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            openUrlLauncher.launch(intent)
                        })
                        .padding(4.dp)
                )
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(if (language=="Español")"Confirmar" else "Confirm")
            }
        }
    )
}


