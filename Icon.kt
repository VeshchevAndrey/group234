package com.example.para1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
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
fun IconImage(){
    val checked = remember { mutableStateOf(false) }
    Column {
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xFF2979FF))
                .fillMaxWidth(1f)){
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
            }
        }
        HorizontalDivider(color = Color.Gray, thickness = 1.dp)
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 5.dp)
                .padding(start = 10.dp)){
            Icon(
                imageVector = Icons.Outlined.AccountCircle,
                contentDescription = "Account",
                tint = Color.Gray,
                modifier = Modifier
            )
            Text(text = "My Account", modifier = Modifier
                .padding(start = 10.dp))
        }
        HorizontalDivider(color = Color.Gray, thickness = 1.dp)
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 5.dp)
                .padding(start = 10.dp)){
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Contacts",
                tint = Color.Gray,
                modifier = Modifier
            )
            Text(text = "Contacts", modifier = Modifier
                .padding(start = 10.dp)
            )
        }
        HorizontalDivider(color = Color.Gray, thickness = 1.dp)
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 5.dp)
                .padding(start = 10.dp)){
            Icon(
                imageVector = Icons.Outlined.Phone,
                contentDescription = "Calls",
                tint = Color.Gray,
                modifier = Modifier
            )
            Text(text = "Calls", modifier = Modifier
                .padding(start = 10.dp))
        }
        HorizontalDivider(color = Color.Gray, thickness = 1.dp)
        IconToggleButton(checked = checked.value, onCheckedChange = { checked.value = it}) {
            Icon(Icons.Outlined.Warning, contentDescription = "Warning",
                tint = if (checked.value) Color.Red else Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestUI() {
    IconImage()
}
