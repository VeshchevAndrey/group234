package com.example.group234

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composer
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.group234.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

@Composable
fun StoriesImage(image: Int, name: String){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Image(bitmap = ImageBitmap.imageResource(image), contentDescription = "Story Image",
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )
        Text(text = name, modifier = Modifier.padding(top = 5.dp))
    }
    Spacer(modifier = Modifier.size(7.dp))
}

@Composable
fun MessageBlock(image: Int, name: String, message: String){
    Row (modifier = Modifier
        .padding(7.dp)
        .height(75.dp)
        ){
        Image(bitmap = ImageBitmap.imageResource(image), contentDescription = "User Avatar",
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )
        Column (modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .padding(horizontal = 7.dp),
            verticalArrangement = Arrangement.SpaceEvenly
            ) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = message, fontWeight = FontWeight.Normal, color = Color.Gray,
                fontSize = 17.sp, overflow = TextOverflow.Ellipsis, softWrap = false)
        }
//        Column (modifier = Modifier
//            .fillMaxWidth(0.1f)){
//            Text(text = "00:00")
//            Text(text = "1")
//        }
    }
    Spacer(modifier = Modifier.size(7.dp))
}

@Composable
fun MainPage(){
    val images = listOf(R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4)
    val names = listOf("Cloud", "Tifa", "Aerith", "Barret")
    val messages = listOf("По своей сути рыбатекст является альтернативой традиционному lorem ipsum, который вызывает у некторых людей недоумение при попытках прочитать рыбу текст. В отличии от lorem ipsum, текст рыба на русском языке наполнит любой макет непонятным смыслом и придаст неповторимый колорит советских времен.", "Goodbye", "What's up?", "Are you OK?")
    Column {
        LazyRow(contentPadding = PaddingValues(5.dp),
            reverseLayout = true, userScrollEnabled = false) {
            itemsIndexed(images){
                index, image -> StoriesImage(image, names[index])
            }
            item { StoriesImage(R.drawable.image1, "My story") }
        }
        LazyColumn (modifier = Modifier
                .fillMaxHeight(1f)
            , userScrollEnabled = false) {
            itemsIndexed(images){
                index, image -> MessageBlock(image, names[index], messages[index])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestUI() {
    MainPage()
}
