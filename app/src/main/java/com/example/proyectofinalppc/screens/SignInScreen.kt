package com.example.proyectofinalppc.screens

import android.graphics.Color
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinalppc.R
import com.example.proyectofinalppc.navigation.AppScreens

@Composable
fun SignIn(navController: NavController) {
    Scaffold {
        SignInBody(navController)
    }
}

@Composable
fun SignInBody(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign In")
        var username by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = username,
            onValueChange = { newText ->
                username = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Username") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )
        var password by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = password,
            onValueChange = { newText ->
                password = newText
            },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
        )
        Button(onClick = {
        }) {
            Text(
                text = "Sign In",
                modifier = Modifier.padding(4.dp)
            )
        }
        Text(
            text = "don't have an account yet?",
            modifier = Modifier.padding(4.dp)
        )
        ClickableText(
            onClick = {
                navController.navigate(route = AppScreens.SignUp.route)
            },
            text = "Sign Up"
        )
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

@Composable
fun ClickableText(onClick: () -> Unit, text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = androidx.compose.ui.graphics.Color.Blue,
            textDecoration = TextDecoration.Underline
        ),
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(4.dp)
    )
}
