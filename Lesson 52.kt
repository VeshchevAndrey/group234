package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val coroutineScope = rememberCoroutineScope()
            val enable = remember { mutableStateOf(true) }
            Column {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            test()
                        }
                    }
                ) { Text("Нажми на меня") }
                Button(
                    onClick = {
                        coroutineScope.launch {
                            println("Запуск второй корутины")
                            delay(3500)
                            println("Остановка второй корутины")
                        }
                    }
                ) { Text("Нажми на меня") }
                Button(
                    enabled = enable.value,
                    onClick = {
                        coroutineScope.launch {
                            enable.value = false
                            delay(3500)
                            enable.value = true
                        }
                    }
                ) { Text("И на меня нажми!") }
            }
        }
    }
}

suspend fun test() {
    println("Корутина запущена!")
    delay(3000)
    println("Корутина завершена!")
}



