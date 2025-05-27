package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val textList = listOf("Горы", "Леса", "Города","Деревни")
            val imageList = listOf(R.drawable.i1,
                R.drawable.i2,
                R.drawable.i3,
                R.drawable.i4)
            val pagerTextState = rememberPagerState { textList.size }
//            val pagerState = rememberPagerState { 10 }
//            HorizontalPager(
//                state = pagerState,
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {page ->
//                Text(text = "Страница ${page+1}")
//            }
            HorizontalPager(state = pagerTextState) {page ->
                Column {
                    Text(text = textList[page])
                    Image(bitmap =  ImageBitmap.imageResource(imageList[page]), contentDescription = "Image")
                }
            }
        }
    }
}
