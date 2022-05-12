package com.example.worldskillsapplication.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.ui.theme.*

@Composable
fun SelectUserDialog(
    onDismiss: () -> Unit

) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Column(
            modifier = Modifier
                .width(800.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(CardColor3),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = "Select users" ,
                color = Color.White ,
                fontSize = 30.sp ,
                fontWeight = FontWeight.Bold ,
                textAlign = TextAlign.Center,
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
                    .background(YellowColor)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Column(Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .weight(0.7f)
                        .background(CardColor2))

                    Spacer(modifier = Modifier.size(32.dp))

                    Column(
                        modifier = Modifier
                            .weight(0.2f)
                            .height(70.dp)
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium)
                            .background(BlueColor)
                            .clickable { },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Select all" ,
                            color = Color.White ,
                            fontSize = 25.sp ,
                            fontWeight = FontWeight.Bold ,
                        )
                    }
                }

                LazyRow(){
                    items(10){
                        SelectUserItem()
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }

                Spacer(modifier = Modifier.size(16.dp))

                Column(Modifier.padding(16.dp)) {
                    Column(
                        Modifier
                            .clip(MaterialTheme.shapes.medium)
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(OrangeColor),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Done" ,
                            color = Color.White ,
                            fontSize = 25.sp ,
                            fontWeight = FontWeight.Bold ,
                        )
                    }
                }

            }




        }
    }

}