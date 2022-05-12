package com.example.worldskillsapplication.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.worldskillsapplication.UserDatabase
import com.example.worldskillsapplication.data.data_source.api.HttpHandler
import com.example.worldskillsapplication.presentation.main_screen.MainScreen
import com.example.worldskillsapplication.presentation.record_screen.RecordScreen
import com.example.worldskillsapplication.presentation.start_screen.StartScreen
import com.example.worldskillsapplication.presentation.utils.Screens
import com.example.worldskillsapplication.ui.theme.WorldSkillsApplicationTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorldSkillsApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }

//        val db = Room.databaseBuilder(this , UserDatabase::class.java , "databaseName").build()
//        val dao = db.getUserDao()

//        lifecycleScope.launch(Dispatchers.IO){
//            val h = HttpHandler().getUsers()
//            runOnUiThread {
//                Toast.makeText(this@MainActivity, h.toString(), Toast.LENGTH_SHORT).show()
//            }
//        }


    }
}

@Composable
fun MainContent(
    viewModel: ViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = Screens.MainScreen.name
    ){
        composable(Screens.MainScreen.name){
            MainScreen(){
                navController.navigate(it)
            }
        }

        composable(Screens.StartScreen.name){
            StartScreen {
                navController.navigate(Screens.MainScreen.name)
            }
        }

        composable(Screens.RecordsScreen.name){
            RecordScreen(nextScreen = {
                navController.navigate(it)

            },
            onBack = {
                navController.navigate(Screens.MainScreen.name)
            })
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorldSkillsApplicationTheme {
        MainContent()
    }
}