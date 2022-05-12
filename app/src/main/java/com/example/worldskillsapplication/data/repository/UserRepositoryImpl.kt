package com.example.worldskillsapplication.data.repository

import com.example.worldskillsapplication.data.data_source.api.HttpHandler
import com.example.worldskillsapplication.data.model.UserModel
import com.example.worldskillsapplication.domain.repository.UserRepository

class UserRepositoryImpl: UserRepository {
    override suspend fun getAllUsers(): UserModel{
        val httpHandler = HttpHandler()
        return httpHandler.getUsers()

    }

}