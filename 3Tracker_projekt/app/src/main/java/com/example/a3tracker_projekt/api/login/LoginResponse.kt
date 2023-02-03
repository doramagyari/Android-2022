package com.example.a3tracker_projekt.api.login

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    var userId: Int,
    var token: String,
    var deadline: Long
)