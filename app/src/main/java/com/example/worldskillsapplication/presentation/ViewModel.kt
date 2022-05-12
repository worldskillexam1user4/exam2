package com.example.worldskillsapplication.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldskillsapplication.UserDatabase
import com.example.worldskillsapplication.data.data_source.api.HttpHandler
import com.example.worldskillsapplication.data.data_source.database.UserTable
import com.example.worldskillsapplication.data.model.User
import com.example.worldskillsapplication.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    val database: UserDatabase,
    val httpHandler: HttpHandler
) : ViewModel() {

    fun insertUser(user: UserTable){
        viewModelScope.launch {
            database.getUserDao().insert(user)
        }
    }

    fun getUsersFromServer(){
        viewModelScope.launch {
            val users = httpHandler.getUsers()
        }
    }

}