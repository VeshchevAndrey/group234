package com.example.para1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composer
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                }
            }
        }

@Composable
fun Compose(){
    val count = rememberSaveable{ mutableStateOf(0) }
    val textSize = rememberSaveable { mutableStateOf(25) }
    val changeText = rememberSaveable { mutableStateOf("Не нажимай...") }
    println(count)
    Column {
        Text(text = "Здесь точно написан текст ${count.value}!!",
            modifier = Modifier
                .clickable(onClick = {count.value += 1}),
            fontSize = textSize.value.sp
            )
        Text(text=changeText.value)
        ComposeButton(textSize, changeText)
    }
}

@Composable
fun ComposeButton(textSize: MutableState<Int>, changeText: MutableState<String>){
    Button(onClick = {
        textSize.value += 1
        changeText.value = "Ну я же просил..."
    }) {
        Text("Нажми на меня!")
    }
}

@Preview(showBackground = true)
@Composable
fun TestUI() {
    Compose()
}
