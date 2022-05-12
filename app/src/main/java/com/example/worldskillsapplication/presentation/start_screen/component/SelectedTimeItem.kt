package com.example.worldskillsapplication.presentation.start_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.ui.theme.TimerItemTextColor

@Composable
fun SelectedTimeItem(
    time: String,
    image: Painter,
    name: String
) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.size(100.dp)) {
                UserItem()
            }

            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = time ,
                    color = Color.White ,
                    fontSize = 30.sp ,
                    fontWeight = FontWeight.Bold ,
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = time ,
                    color = TimerItemTextColor ,
                    fontSize = 25.sp ,
                )



            }

        }

        Spacer(modifier = Modifier.size(8.dp))

        Divider(Modifier.fillMaxWidth() , color = Color(0xff096F96))
    }
}