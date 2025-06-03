package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(){
    val companions = listOf(
        Companion(1, "Cloud Strife", R.drawable.i1),
        Companion(2, "Tifa Lockhart", R.drawable.i2),
        Companion(3, "Aerith Gainsborough", R.drawable.i3),
        Companion(4, "Barret Wallace", R.drawable.i4),
    )
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "companions") {
        composable(route = "companions") {
            CompanionScreen(companionsList = companions, navController = navController)
        }
        composable(
            route = "companion" + "{companionId}",
            arguments = listOf(navArgument("companionId") {
                type = NavType.IntType
            }
            )
        ) {
            val companionId = it.arguments?.getInt("companionId")
            SingleCompanion(companionId, companions, navController)
        }
    }
}

@Composable
fun CompanionScreen(companionsList: List<Companion>, navController: NavController){
    LazyColumn {
        itemsIndexed(companionsList){index, companion ->
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .clickable {
                        navController.navigate("companion${companion.companionId}")
                    }
            ){
                Image(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(shape = CircleShape)
                        .size(75.dp),
                    bitmap = ImageBitmap.imageResource(companion.companionImage),
                    contentDescription = "Companion Image"
                )
                Text(
                    text = companion.companionName
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleCompanion(companionId: Int?, data: List<Companion>, navController: NavController){
    val companion = data.find { it.companionId == companionId }
    if (companion != null){
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = companion.companionName)
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigate(route = "companions")
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Row (
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                Image(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(shape = CircleShape)
                        .size(75.dp),
                    bitmap = ImageBitmap.imageResource(companion.companionImage),
                    contentDescription = "Companion Image"
                )
                Text(
                    text = companion.companionName
                )
            }
        }

    }
    else {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Error")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigate(route = "companions")
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column (
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                Text(text = "User is not exist!")
            }
        }
    }
}

@Composable
fun SingleCompanionScaffold(){

}

data class Companion(val companionId: Int, val companionName: String, val companionImage: Int)
