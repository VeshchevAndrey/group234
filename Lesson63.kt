package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold (
                bottomBar = { NavigationBar(navController) }
            ){
                Main(navController, it)
            }
        }
    }
}

@Composable
fun Main(navController: NavHostController, paddingValues: PaddingValues){
    NavHost(
        modifier = Modifier
            .padding(paddingValues),
        navController = navController,
        startDestination = "conventer"
    ){
        composable( route = "conventer") { Converter() }
    }
}

@Composable
fun NavigationBar(navController: NavController){
    BottomAppBar {
        IconButton(onClick = {navController.navigate("conventer")}) {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.currency_exchange_24px),
                contentDescription = "Converter")
        }
    }
}
