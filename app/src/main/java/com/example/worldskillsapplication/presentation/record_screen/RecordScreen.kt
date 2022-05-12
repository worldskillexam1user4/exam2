package com.example.worldskillsapplication.presentation.record_screen

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.presentation.bestrecord_screen.BestRecordScreen
import com.example.worldskillsapplication.presentation.main_screen.components.MyTextButton
import com.example.worldskillsapplication.presentation.main_screen.components.SelectFieldDialog
import com.example.worldskillsapplication.presentation.main_screen.components.SelectUserDialog
import com.example.worldskillsapplication.presentation.overall_screen.OverAllScreen
import com.example.worldskillsapplication.presentation.start_screen.StartScreen
import com.example.worldskillsapplication.presentation.utils.Screens
import com.example.worldskillsapplication.ui.theme.*

@Composable
fun RecordScreen(
    onBack: () -> Unit,
    nextScreen: (root: String) -> Unit
) {
    val context = LocalContext.current
    val navController = rememberNavController()


    var navState by remember {
        mutableStateOf(false)
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Brush.radialGradient(listOf(GradiantColor1, GradiantColor2)))
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.main_bg),
            contentDescription = "mainScreen",
            contentScale = ContentScale.Crop
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 32.dp)) {
            IconButton(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .align(Alignment.TopStart)
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

            Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier.align(Alignment.TopCenter)) {
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
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(64.dp)
                .padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .size(500.dp, 70.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(CardColor4)
                    .padding(4.dp)
            ) {


                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.medium)
                        .background(if (!navState) Color.White else Color.Transparent)
                        .clickable {
                            navState = false
                            navController.navigate("start")
                                   },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Over all",
                        color = if (!navState) TextColor4 else TextColor3,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.size(8.dp))

                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.medium)
                        .background(if (navState) Color.White else Color.Transparent)
                        .clickable {
                            navState = true
                            navController.navigate("start")
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Best record",
                        color = if (navState) TextColor4 else TextColor3,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }


            }

            Spacer(modifier = Modifier.size(16.dp))

            Column(
                Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.medium)
                    .background(CardColor5)
//                    .padding(horizontal = 64.dp, vertical = 16.dp)
//                    .padding(bottom = 32.dp)
            ) {


                NavHost(
                    navController = navController,
                    startDestination = "start"
                ) {
                    composable("start"){
                        SelectTab(navState = navState, navController = navController , context = context)
                    }

                    composable(Screens.OverAllRecordScreen.name){
                        OverAllScreen(){
                            navController.navigate("start")
                        }
                    }

                    composable(Screens.BestRecordScreen.name){
                        BestRecordScreen(){
                            navController.navigate("start")
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

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SelectTab(navState: Boolean , navController: NavController , context: Context) {
    var dateText by remember {
        mutableStateOf("Select date")
    }

    var dateState by remember {
        mutableStateOf(false)
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.size(64.dp))

        if (!navState){
            MyTextButton(text = dateText , state = dateState) {
                val date = DatePickerDialog(context)
                date.setOnDateSetListener { datePicker, i, i2, i3 ->
                    dateText = "$i / $i2 / $i3"
                    dateState = true
                }
                date.show()
            }

            Spacer(modifier = Modifier.size(16.dp))
        }

        var fieldState by remember {
            mutableStateOf(false)
        }

        MyTextButton(text = "Select field ..." , state = false) {
            fieldState = true
        }

        if (fieldState){
            SelectFieldDialog(){image , text ->
                fieldState = false
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        if (!navState){

            var userState by remember {
                mutableStateOf(false)
            }

            MyTextButton(text = "Select users ..." , state = false) {
                userState = true
            }

            if (userState){
                SelectUserDialog(){
                    userState = false
                }
            }
            Spacer(modifier = Modifier.size(16.dp))

        }

        Column(
            modifier = Modifier
                .size(400.dp, 70.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            StartButtonGradiantColor1,
                            StartButtonGradiantColor2
                        )
                    )
                )
                .clickable {
                    navController.navigate(
                        if (navState)
                            Screens.BestRecordScreen.name
                        else
                            Screens.OverAllRecordScreen.name
                    )

                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
            ){

                Icon(
                    painter = painterResource(id = R.drawable.chart_ic),
                    contentDescription = "Chart icon",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Show" ,
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }

        }


    }
}

@Preview(widthDp = 900 , heightDp = 600)
@Composable
fun MainScreenPreview() {
    WorldSkillsApplicationTheme {
        RecordScreen(onBack = {} ){
        }
    }

}