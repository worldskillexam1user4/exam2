package com.example.worldskillsapplication.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.*
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
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.ui.theme.CardColor3
import com.example.worldskillsapplication.ui.theme.OrangeColor
import com.example.worldskillsapplication.ui.theme.YellowColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectFieldDialog(
    onDismiss: ( image: Int , text: String) -> Unit
) {
    var fieldImage by remember {
        mutableStateOf(R.drawable.ic_launcher_background)
    }
    var fieldText by remember {
        mutableStateOf("Butterfly swim")
    }

    val dismissState = rememberDismissState()
    val scope = rememberCoroutineScope()
    Dialog(onDismissRequest = { onDismiss(fieldImage , fieldText) }) {
        Column(
            modifier = Modifier
                .size(width = 700.dp, 500.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(CardColor3),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = "Select field" ,
                color = Color.White ,
                fontSize = 30.sp ,
                fontWeight = FontWeight.Bold ,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .size(width = 200.dp, height = 70.dp)
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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        fieldImage = R.drawable.swim1_ic
                        fieldText = "Butterfly swim"
//                        scope.launch {
//                            dismissState.dismiss()
//                        }
                    }
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.swim1_ic),
                    contentDescription = "icon"
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "Butterfly swim" ,
                    color = OrangeColor ,
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold ,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { }
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.swim2_ic),
                    contentDescription = "icon"
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "Freestyle swim" ,
                    color = OrangeColor ,
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold ,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { }
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.swim3_ic),
                    contentDescription = "icon"
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "Breaststroke swim" ,
                    color = OrangeColor ,
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold ,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { }
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.swim4_ic),
                    contentDescription = "icon"
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "Backstroke swim" ,
                    color = OrangeColor ,
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold ,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { }
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.swim5_ic),
                    contentDescription = "icon"
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "Sidestroke swim" ,
                    color = OrangeColor ,
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold ,
                )
            }



        }
    }
}