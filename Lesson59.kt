package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.group234.ui.theme.Group234Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Column {
                NavHost(
                    navController = navController, startDestination = "main"
                ) {
                    composable(route = "main") {
                        Main()
                    }
                    composable(route = "setting") {
                        Settings()
                    }
                    composable(route = "about") {
                        About()
                    }
                }
                Row {
                    TextButton(
                        onClick = {
                            navController.navigate(route = "main") {
                                popUpTo(route = "main")
                            }
                        }
                    ) {
                        Text(text = "Основной экран")
                    }
                    TextButton(
                        onClick = {
                            navController.navigate(route = "setting")
                        }
                    ) {
                        Text(text = "Настройки")
                    }
                    TextButton(
                        onClick = {
                            navController.navigate(route = "about")
                        }
                    ) {
                        Text(text = "Подробнее")
                    }
                }
            }

        }
    }
}

@Composable
fun Main(){
    Text(text = "Основной экран")
}

@Composable
fun Settings(){
    Text(text = "Настройки")
}

@Composable
fun About(){
    Text(text = "Подробнее")
}
