package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            val textLabel = remember { mutableStateOf("И на меня нажми!") }
            Scaffold (
                snackbarHost = {
                    SnackbarHost(hostState = snackbarHostState){data ->
                        Snackbar(
                            snackbarData = data,
                            actionOnNewLine = true,
                            shape = RoundedCornerShape(size = 10.dp),
                            containerColor = Color.DarkGray,
                            contentColor = Color.Yellow,
                            actionColor = Color.Yellow
                        )
                    }
                }
            ){
                Column (modifier = Modifier
                    .padding(it)) {
                    Button(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Кнопка была нажата!")
                            }
                        }
                    ) { Text("Нажми на кнопку!") }
                    Button(
                        onClick = {
                            scope.launch {
                                var result = snackbarHostState.showSnackbar(
                                    message = "Смотри что я могу!",
                                    actionLabel = "Посмотреть",
                                    duration = SnackbarDuration.Short
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    textLabel.value = "Ура, ты сделал это!"
                                }
                            }
                        }
                    ) { Text( text = textLabel.value) }
                    Button(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "А меня можно закрыть быстрее!",
                                    withDismissAction = true
                                )
                            }
                        }
                    ) { Text(text = "Не забудь нажать сюда!") }
                }
            }
        }
    }
}


