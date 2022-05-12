package com.example.worldskillsapplication.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val fields: List<Field>,
    val users: List<User>,
    val workouts: List<Workout>
)

@Serializable
data class Field(
    val icon: String,
    val id: String,
    val name: String
)

@Serializable
data class User(
    val id: String,
    val name: String,
    val photo: String
)

@Serializable
data class Workout(
    val date: String,
    val duration: String,
    val fieldid: String,
    val id: String,
    val userid: String
)