package com.example.a3tracker_projekt.repo

import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.api.login.LoginResponse
import com.example.a3tracker_projekt.api.login.UserApi
import retrofit2.Response


class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}