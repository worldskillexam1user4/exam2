package com.example.worldskillsapplication.presentation.start_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.worldskillsapplication.R

@Composable
fun UserItem(
) {
    Column(modifier = Modifier
        .padding(8.dp)
        .aspectRatio(1f)
        .fillMaxSize()
        .clip(MaterialTheme.shapes.medium)
        .border(width = 5.dp, color = Color.White, shape = MaterialTheme.shapes.medium)
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "User image")
    }
}