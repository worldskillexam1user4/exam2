package com.example.worldskillsapplication.presentation.bestrecord_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.presentation.bestrecord_screen.component.RecordItem
import com.example.worldskillsapplication.ui.theme.YellowColor
import com.example.worldskillsapplication.ui.theme.YellowColor2

@Composable
fun BestRecordScreen(
    onBack: () -> Unit
) {
    Box (Modifier.fillMaxSize()){
       Column(
           modifier = Modifier
               .size(width = 300.dp, height = 70.dp)
               .clip(
                   RoundedCornerShape(
                       topEnd = 0.dp,
                       topStart = 0.dp,
                       bottomEnd = 16.dp,
                       bottomStart = 16.dp
                   )
               )
               .background(Color.White.copy(alpha = 0.6f))
               .align(Alignment.TopCenter)
           ,
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally

       ) {
           Text(
               text = "Butterfly swim" ,
               color = YellowColor ,
               fontSize = 30.sp ,
               fontWeight = FontWeight.Bold ,
               textAlign = TextAlign.Center,
           )
       }

        Column(
            modifier = Modifier
                .size(width = 70.dp, height = 40.dp)
                .clip(
                    RoundedCornerShape(
                        topEnd = 0.dp,
                        topStart = 16.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 0.dp
                    )
                )
                .background(YellowColor2)
                .align(Alignment.TopStart)
                .clickable {
                    onBack()
                }
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Icon(painter = painterResource(id = R.drawable.back2_ic), contentDescription = "backIc" , tint = Color.White)
        }
        
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 64.dp)) {

            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                items(10){
                    RecordItem(it)
                }
            }
        }
    }
}