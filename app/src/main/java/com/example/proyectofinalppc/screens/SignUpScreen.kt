package com.example.proyectofinalppc.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectofinalppc.R
import com.example.proyectofinalppc.navigation.AppScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUp(navController: NavController) {
    Scaffold {
        SignUpBody(navController)
    }
}

@Composable
fun SignUpBody(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            if (language=="Español")"Registrar cuenta" else "Sign up",
            style = TextStyle(
                fontSize = 50.sp
            )
        )

        Spacer(modifier = Modifier.height(100.dp))

        var username by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = username,
            onValueChange = { newText ->
                username = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text(if (language=="Español")"Nombre de usuario" else "Username") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(5.dp))

        var email by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = email,
            onValueChange = { newText ->
                email = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text(if (language=="Español")"Correo electronico" else "Email") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(5.dp))

        var password by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = password,
            onValueChange = { newText ->
                password = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text(if (language=="Español")"Contraseña" else "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(5.dp))

        var cPassword by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = cPassword,
            onValueChange = { newText ->
                cPassword = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text(if (language=="Español")"Confirmar contraseña" else "Confirm password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Button(onClick = {
        }) {
            Text(
                text = if (language=="Español")"Registrar cuenta" else "Sign up",
                modifier = Modifier.padding(4.dp)
            )
        }
    }
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
}