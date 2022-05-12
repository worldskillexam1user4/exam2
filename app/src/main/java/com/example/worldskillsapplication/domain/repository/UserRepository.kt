package com.example.worldskillsapplication.domain.repository

import com.example.worldskillsapplication.data.model.UserModel

interface UserRepository {

    suspend fun getAllUsers(): UserModel
}