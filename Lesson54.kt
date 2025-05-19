package com.example.group234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val menuList = listOf("Profile", "Groups", "Contacts")
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val selectedItem = remember { mutableStateOf(menuList[0]) }
//            ModalNavigationDrawer(
//                drawerState = drawerState,
//                drawerContent = {
//                    TextButton(onClick = {
//                        scope.launch {
//                            drawerState.close()
//                            selectedItem.value = "Пункт 1"
//                        }
//                    }) { Text(text = "Пункт 1") }
//                },
//                scrimColor = Color(0xFFFCA903),
//                content = {
//                    Column {
//                        IconButton(onClick = {
//                            scope.launch {
//                                drawerState.open()
//                            }
//                        }) {
//                            Icon(Icons.Filled.Menu, contentDescription = "DrawerMenu")
//                        }
//                        Text(text = selectedItem.value)
//                    }
//                }
//            )
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet (
                        drawerShape = RectangleShape
                    ){
                        menuList.forEach{item ->
                            NavigationDrawerItem(
                                label = { Text(text = item) },
                                icon = { Icon(Icons.Filled.Add, contentDescription = "Icon") },
                                badge = { Icon(Icons.Filled.Add, contentDescription = null) },
                                selected = (selectedItem.value == item),
                                onClick = {
                                    scope.launch { drawerState.close() }
                                    selectedItem.value = item
                                }
                            )
                        }
                    }
                },
            ) { Scaffold (
                topBar = {
                    TopAppBar(
                        title = { Text(text = selectedItem.value) },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch { drawerState.open() }
                            }
                            ) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu")
                            }
                        },
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(Icons.Filled.MoreVert, contentDescription = "More")
                            }
                        }
                    )
                }
            ) {
                Column (modifier = Modifier
                    .padding(it)
                ) {

                }
            }}
        }
    }
}


