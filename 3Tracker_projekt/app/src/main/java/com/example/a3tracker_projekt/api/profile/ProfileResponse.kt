package com.example.a3tracker_projekt.api.profile

import com.google.gson.annotations.SerializedName

data class ProfileResponse (
    @SerializedName("message")
    var message : String
)