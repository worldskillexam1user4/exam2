package com.example.worldskillsapplication.di

import android.content.Context
import androidx.room.Room
import com.example.worldskillsapplication.UserDatabase
import com.example.worldskillsapplication.data.data_source.api.HttpHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase{
        return Room.databaseBuilder(context , UserDatabase::class.java , UserDatabase.name).build()
    }

    @Provides
    @Singleton
    fun provideHttpHandler(): HttpHandler{
        return HttpHandler()
    }
}