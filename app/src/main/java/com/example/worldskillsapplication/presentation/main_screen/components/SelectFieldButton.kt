package com.example.worldskillsapplication.presentation.main_screen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.ui.theme.TextButtonGradiantColor1
import com.example.worldskillsapplication.ui.theme.TextButtonGradiantColor2
import com.example.worldskillsapplication.ui.theme.TextColor1
import com.example.worldskillsapplication.ui.theme.TextColor4

@Composable
fun SelectFieldButton(
    text: String,
    state: Boolean,
    image: Painter = painterResource(id = R.drawable.ic_launcher_background),
    onClick: () -> Unit,

    ) {

    Column(
        modifier = Modifier
            .size(400.dp, 70.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                Brush.horizontalGradient(
                    listOf(
                        TextButtonGradiantColor1,
                        TextButtonGradiantColor2
                    )
                )
            )
            .clickable {
                onClick()
            },

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        if (!state){
            Text(
                text = text,
                color = if (state) TextColor4 else TextColor1,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = if (state) FontWeight.Bold else FontWeight.Normal
            )
        }else{
            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    modifier = Modifier.size(48.dp),
                    painter = image,
                    contentDescription = "image"
                )

                Spacer(modifier = Modifier.size(16.dp))

                Text(
                    text = text,
                    color = if (state) TextColor4 else TextColor1,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = if (state) FontWeight.Bold else FontWeight.Normal
                )

            }
        }
    }

}