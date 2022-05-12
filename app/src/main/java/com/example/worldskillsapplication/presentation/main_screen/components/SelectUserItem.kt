package com.example.worldskillsapplication.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.ui.theme.GreenColor
import com.example.worldskillsapplication.ui.theme.OrangeColor
import com.example.worldskillsapplication.ui.theme.TextColor2

@Composable
fun SelectUserItem() {
    var state by remember {
        mutableStateOf(false)
    }
    
    Column(modifier = Modifier.clickable {
                                         state = !state
    },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        

        Box(modifier = Modifier
            .size(100.dp)
            .clip(MaterialTheme.shapes.medium)){
            
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .border(
                        width = if (state) 2.dp else 0.dp,
                        color = GreenColor,
                        shape = MaterialTheme.shapes.medium
                    ),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription ="User Image"
            )
            
            if (state){

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(width = 40.dp, height = 20.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 16.dp
                            )
                        )
                        .padding(0.dp)
                        .background(GreenColor)
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ok_ic),
                        contentDescription ="",
                        tint = Color.White
                    )
                }
                }

        }

        Text(
            text = "Mahdi Iranmanesh" ,
            color = if(state) GreenColor else TextColor2 ,
            fontSize = 15.sp ,
            fontWeight = FontWeight.Bold ,
        )

    }
}