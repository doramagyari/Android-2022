package com.example.a3tracker_projekt.api.login

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(var email: String, var passwordKey: String )