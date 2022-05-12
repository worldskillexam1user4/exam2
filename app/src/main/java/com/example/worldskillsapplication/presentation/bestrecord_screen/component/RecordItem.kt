package com.example.worldskillsapplication.presentation.bestrecord_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.presentation.start_screen.component.UserItem
import com.example.worldskillsapplication.ui.theme.*

@Composable
fun RecordItem(
    position: Int
) {

    val color = when(position){
        0 -> GoldColor
        1 -> SilverColor
        2 -> BronzeColor
        else -> NormalStateColor
    }
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "$position." ,
                color = color ,
                fontSize = 35.sp ,
                fontWeight = FontWeight.Bold ,
            )

            Spacer(modifier = Modifier.size(16.dp))

            Column(Modifier.size(100.dp)) {
                UserItem()
            }
            Spacer(modifier = Modifier.size(16.dp))

            Row(Modifier.fillMaxWidth().padding(end = 16.dp) , horizontalArrangement = Arrangement.SpaceBetween) {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "name:" ,
                        color = TextColor6 ,
                        fontSize = 20.sp ,
                        fontWeight = FontWeight.Bold ,
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = "Mahdi Iranmanesh" ,
                        color = color ,
                        fontSize = 25.sp ,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "duration:" ,
                        color = TextColor6 ,
                        fontSize = 20.sp ,
                        fontWeight = FontWeight.Bold ,
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = "00 : 11 : 10" ,
                        color = color ,
                        fontSize = 25.sp ,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "date:" ,
                        color = TextColor6 ,
                        fontSize = 20.sp ,
                        fontWeight = FontWeight.Bold ,
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = "2022 / 05 / 12" ,
                        color = color ,
                        fontSize = 25.sp ,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }

        Spacer(modifier = Modifier.size(8.dp))

        Divider(Modifier.fillMaxWidth() , color = Color(0xff096F96))
    }
}