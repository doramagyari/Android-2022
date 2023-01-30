package com.example.a3tracker_projekt.api.users

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class MyUser(
    var ID: Int,
    var first_name: String,
    var last_name: String,
    var email: String,
    var address :String,
    var type: Int,
    var department_id: Int,
    var location: String,
    var imageUrl: String,
    var start_date:Date,
    var phone_number: String
)