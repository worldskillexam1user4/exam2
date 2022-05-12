package com.example.worldskillsapplication

import androidx.room.*
import com.example.worldskillsapplication.data.data_source.database.UserDao
import com.example.worldskillsapplication.data.data_source.database.UserTable

@Database(entities = [UserTable::class] , version = 1)
abstract class UserDatabase(): RoomDatabase(){
    abstract fun getUserDao(): UserDao

    companion object{
        val name = "database"
    }
}