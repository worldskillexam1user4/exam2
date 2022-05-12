package com.example.worldskillsapplication.presentation.start_screen

import android.widget.GridLayout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.presentation.main_screen.MainScreen
import com.example.worldskillsapplication.presentation.main_screen.components.MyTextButton
import com.example.worldskillsapplication.presentation.start_screen.component.SelectedTimeItem
import com.example.worldskillsapplication.presentation.start_screen.component.TimerItem
import com.example.worldskillsapplication.presentation.start_screen.component.UserItem
import com.example.worldskillsapplication.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun StartScreen(
    onBack: () -> Unit
) {
    var time by remember {
        mutableStateOf(0)
    }

    var timerState by remember {
        mutableStateOf(false)
    }

    Box(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.radialGradient(listOf(GradiantColor1, GradiantColor2)))
        )


        Box(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.main_bg),
                contentDescription = "mainScreen",
                contentScale = ContentScale.Crop
            )

            Column(Modifier.fillMaxSize()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {


                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,

                        ) {

                        IconButton(
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.small)
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            ChartButtonGradiantColor1, ChartButtonGradiantColor2
                                        )
                                    )
                                ),
                            onClick = { onBack() }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.back_ic),
                                contentDescription = "back icon"
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                modifier = Modifier.size(80.dp),
                                painter = painterResource(id = R.drawable.app_ic),
                                contentDescription = "App Icon"
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Image(
                                modifier = Modifier.size(width = 160.dp , height = 60.dp),
                                painter = painterResource(id = R.drawable.worldskills_ic),
                                contentDescription = "App Icon",
                            )
                        }

                        IconButton(
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.small)
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            ChartButtonGradiantColor1, ChartButtonGradiantColor2
                                        )
                                    )
                                ),
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.chart_ic),
                                contentDescription = "Chart icon"
                            )
                        }

                    }
                }
            }


            Row(
                Modifier
                    .fillMaxSize()
                    .padding(64.dp)
                    .padding(top = 32.dp),

                ) {

                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.size(16.dp))
                    
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(width = 300.dp , height = 70.dp),
                            painter = painterResource(id = R.drawable.swim_text_ic), contentDescription = "")
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Column(
                        Modifier
                            .clip(MaterialTheme.shapes.medium)
                            .fillMaxSize()
                            .background(CardColor)
                            .padding(32.dp)
                    ) {

                            LazyVerticalGrid(
                                modifier = Modifier.fillMaxSize(),
                                columns = GridCells.Fixed(4)){
                                items(10){
                                    UserItem()
                                }
                            }

                    }

                }

                Spacer(modifier = Modifier.size(16.dp))

                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.size(16.dp))

                    Row(Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        TimerItem((time / 3600).toString()) //hour

                        Text(
                            text = ":",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )

                        TimerItem((time / 60).toString()) // min

                        Text(
                            text = ":",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )

                        TimerItem((time % 60).toString()) // hour

                        Spacer(modifier = Modifier.size(16.dp))

                        IconButton(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(MaterialTheme.shapes.medium)
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            TimerButtonGradiantColor1,
                                            TimerButtonGradiantColor2
                                        )
                                    )
                                ),
                            onClick = {
                                timerState = !timerState


                            },
                        ) {
                            Icon(
                                painter = painterResource(id = if (timerState) R.drawable.pause_ic else R.drawable.play_ic),
                                contentDescription = "Play Button",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        if (timerState){
                            LaunchedEffect(key1 = true){
                                while (timerState){
                                    delay(1000)
                                    time = (time + 1)
                                }
                            }
                        }

                        IconButton(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(MaterialTheme.shapes.medium)
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            TimerButtonGradiantColor1,
                                            TimerButtonGradiantColor2
                                        )
                                    )
                                ),
                            onClick = {
                                      timerState = false
                                time = 0
                            },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.reset_ic),
                                contentDescription = "Reset Button",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.size(16.dp))
                    
                    Column(
                        Modifier
                            .clip(MaterialTheme.shapes.medium)
                            .fillMaxSize()
                            .background(CardColor2)
                            .padding(16.dp)
                    ) {
                        LazyColumn {
                            items(10){
                                SelectedTimeItem(
                                    time = "00 : 11 : 10",
                                    image = painterResource(id = R.drawable.ic_launcher_background),
                                    name = "Mahdi"
                                )
                            }
                        }
                    }
                    
                }


            }

            Text(text = "Kerman" ,
                color = Color.White.copy(alpha = 0.5f),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)

            )
        }
    }
}

@Preview(widthDp = 900 , heightDp = 600)
@Composable
fun MainScreenPreview() {
    WorldSkillsApplicationTheme {
        StartScreen(){

        }
    }

}