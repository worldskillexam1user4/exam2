package com.example.worldskillsapplication.data.data_source.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.worldskillsapplication.data.model.User

@Dao
interface UserDao{
    @Insert
    fun insert(user:UserTable)

    @Delete
    fun delete(user: UserTable)
}