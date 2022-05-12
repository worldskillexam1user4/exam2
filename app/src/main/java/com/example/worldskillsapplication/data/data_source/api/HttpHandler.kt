package com.example.worldskillsapplication.data.data_source.api

import android.net.sip.SipErrorCode.TIME_OUT
import android.util.Log
import com.example.worldskillsapplication.data.model.UserModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class HttpHandler {

    val client = HttpClient(Android){
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }

            }
            level = LogLevel.ALL
        }



        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    suspend fun getUsers(): UserModel{
        val url = "https://ktvu.ir/worldskills/get_data.php"

        val response = client.get<UserModel>(url)
        return response
    }
}