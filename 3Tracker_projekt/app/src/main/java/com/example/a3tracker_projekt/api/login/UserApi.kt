package com.example.a3tracker_projekt.api.login

import com.example.a3tracker_projekt.api.ApiClient
import com.sapientia.login.demo.api.ApiClient
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface UserApi {

    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}