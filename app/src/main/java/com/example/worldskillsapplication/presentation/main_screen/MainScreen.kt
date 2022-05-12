package com.example.worldskillsapplication.presentation.main_screen

import android.app.DatePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapplication.R
import com.example.worldskillsapplication.presentation.main_screen.components.MyTextButton
import com.example.worldskillsapplication.presentation.main_screen.components.SelectFieldButton
import com.example.worldskillsapplication.presentation.main_screen.components.SelectFieldDialog
import com.example.worldskillsapplication.presentation.main_screen.components.SelectUserDialog
import com.example.worldskillsapplication.presentation.utils.Screens
import com.example.worldskillsapplication.ui.theme.*
import io.ktor.util.*
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    nextScreen: (root : String) -> Unit
) {
    val context = LocalContext.current

    var dateText by remember {
        mutableStateOf("Select date")
    }

    var dateState by remember {
        mutableStateOf(false)
    }

    var fieldImage by remember {
        mutableStateOf(R.drawable.ic_launcher_background)
    }
    var fieldText by remember {
        mutableStateOf("Select field")
    }

    var fieldState by remember {
        mutableStateOf(false)
    }

    var fieldStateDialog by remember {
        mutableStateOf(false)
    }



    var splashState by remember {
        mutableStateOf(true)
    }

   Box(Modifier.fillMaxSize()) {
       Box(modifier = Modifier
           .fillMaxSize()
           .background(Brush.radialGradient(listOf(GradiantColor1, GradiantColor2))))

       if (splashState) {
           Column(
               modifier = Modifier
                   .fillMaxSize(),
               
           ) {

               AnimatedVisibility(
                   visible = splashState,
                   enter = scaleIn(animationSpec = tween(500)),
               ) {
                   LaunchedEffect(key1 = true){
                       delay(700)
                       splashState = false
                   }
                   Box(Modifier.fillMaxSize()) {
                       Image(
                           modifier = Modifier.fillMaxSize(),
                           painter = painterResource(id = R.drawable.main_bg),
                           contentDescription = "mainScreen",
                           contentScale = ContentScale.Crop
                       )
                       
                       Column(modifier = Modifier.align(Alignment.Center),
                           horizontalAlignment = Alignment.End
                       ) {
                           Image(
                               modifier = Modifier
                                   .size(80.dp)
                                   .padding(end = 16.dp),
                               painter = painterResource(id = R.drawable.app_ic),
                               contentDescription = "App Icon"
                           )
                           Image(
                               modifier = Modifier.size(width = 160.dp , height = 60.dp),
                               painter = painterResource(id = R.drawable.worldskills_ic),
                               contentDescription = "App Icon",
                           )

                           Row(horizontalArrangement = Arrangement.SpaceBetween) {
                               Text(
                                   text = "Kerman",
                                   color = TextColor5,
                                   fontSize = 30.sp,
                                   fontWeight = FontWeight.Bold,
                                   textAlign = TextAlign.Center,
                               )

                               Text(
                                   text = "2022",
                                   color = TextColor5,
                                   fontSize = 30.sp,
                                   fontWeight = FontWeight.Bold,
                                   textAlign = TextAlign.Center,
                               )

                           }


                       }
                   }

               }



           }
       } else { //Main
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
                           .padding(horizontal = 32.dp, vertical = 16.dp),
                       horizontalArrangement = Arrangement.SpaceBetween,

                       ) {
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
                           onClick = { nextScreen(Screens.RecordsScreen.name) }
                       ) {
                           Icon(
                               painter = painterResource(id = R.drawable.chart_ic),
                               contentDescription = "Chart icon"
                           )
                       }

                   }

                   Column(
                       Modifier.fillMaxSize(),
                       horizontalAlignment = Alignment.CenterHorizontally,

                   ) {
                       Spacer(modifier = Modifier.size(64.dp))

                       MyTextButton(text = dateText , state = dateState) {
                           val date = DatePickerDialog(context)
                           date.setOnDateSetListener { datePicker, i, i2, i3 ->
                               dateText = "$i / $i2 / $i3"
                               dateState = true
                           }
                           date.show()
                       }

                       Spacer(modifier = Modifier.size(16.dp))


                       SelectFieldButton(
                           text = fieldText ,
                           state = fieldState ,
                           image = painterResource(id = fieldImage)
                       ) {
                           fieldStateDialog = true
                       }

                       if (fieldStateDialog){
                           SelectFieldDialog(){ image , text ->

                               fieldImage = image
                               fieldText = text
                               fieldState = true
                               fieldStateDialog = false
                           }
                       }

                       Spacer(modifier = Modifier.size(16.dp))

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
                                   nextScreen(
                                       Screens.StartScreen.name
                                   )
                               },
                           verticalArrangement = Arrangement.Center,
                           horizontalAlignment = Alignment.CenterHorizontally
                       ) {
                           Row(
                           ){

                               Icon(
                                   painter = painterResource(id = R.drawable.play_ic),
                                   contentDescription = "Play icon",
                                   tint = Color.White,
                                   modifier = Modifier.size(32.dp)
                               )

                               Spacer(modifier = Modifier.size(16.dp))
                               Text(text = "Start" ,
                                   color = Color.White,
                                   fontSize = 30.sp,
                                   fontWeight = FontWeight.Bold,
                                   textAlign = TextAlign.Center,
                               )
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

    LaunchedEffect(key1 = true){
        delay(50)
        splashState = true
    }



}




@Preview(widthDp = 900 , heightDp = 600)
@Composable
fun MainScreenPreview() {
    WorldSkillsApplicationTheme {
        MainScreen(){

        }
    }

}