package com.example.worldskillsapplication.presentation.overall_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.worldskillsapplication.R
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun UserChartItem() {

    val color = Color(red = Random.nextInt(1..255) , blue = Random.nextInt(1..255) , green = Random.nextInt(1..255))

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .size(16.dp)
            .clip(CircleShape)
            .background(color))

        Spacer(modifier = Modifier.size(8.dp))

        Image(
            modifier = Modifier.size(48.dp)
                .clip(MaterialTheme.shapes.medium)
                .shadow(8.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "User Image"
        )

    }
}