package com.example.worldskillsapplication.presentation.start_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.ui.theme.TimerGradiantColor1
import com.example.worldskillsapplication.ui.theme.TimerGradiantColor2
import com.example.worldskillsapplication.ui.theme.TimerTextColor

@Composable
fun TimerItem(
    text: String
) {
    Column(
        modifier =
        Modifier.size(64.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                Brush.horizontalGradient(listOf(
                    TimerGradiantColor1 ,
                TimerGradiantColor2
                )))
            ,

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            color = TimerTextColor,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}