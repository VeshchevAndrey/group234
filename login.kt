package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.group234.ui.theme.Group234Theme

// onCreate() - точка входа в приложение (аналог main())
// setContent() - описание (определение) макета запускаемого окна приложения
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun TestUI(){
    val message = remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxWidth(1f), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter your name:", modifier = Modifier
            .padding(0.dp, 3.dp)
            .background(Color(0xFF3F51B5))
            .padding(0.dp, 3.dp)
            .fillMaxWidth(1f),
            color = Color.White, fontSize = 20.sp, fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Light, FontFamily.Default,
            textDecoration = TextDecoration.None, textAlign = TextAlign.Justify,
            style = TextStyle(textIndent = TextIndent(10.sp, 5.sp), textDirection = TextDirection.Ltr)
        )
        OutlinedTextField(value = message.value, modifier = Modifier
            .fillMaxWidth(1f),
            onValueChange = {newText -> message.value = newText},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 20.sp),
            placeholder = {Text("Your name")},
            trailingIcon = { IconButton(onClick = {message.value = ""})  {
                Icon(Icons.Filled.Delete, contentDescription = "Clear field")
            }},
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color(0xFF3F51B5),
                unfocusedContainerColor = Color(0xFFC9D0D3),
                focusedContainerColor = Color.White,
                focusedBorderColor = Color(0xFF3F51B5)
            )
        )
        Button(onClick = {
            if (message.value != "") {
                message.value = ""
                }
        },
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp,
                hoveredElevation = 4.dp,
                focusedElevation = 4.dp
            ),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF3F51B5)
            )
        ) { Text(text = "Login", fontSize = 20.sp, fontWeight = FontWeight.Light) }
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview(){
    TestUI()
}
