package com.example.a3tracker_projekt.api.users

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class MyUser(
    var ID: Int,
    var last_name: String,
    var first_name: String,
    var email: String,
    var type: Int,
    var location: String,
    var phone_number: String,
    var department_id: Int,
    var image: String
)
