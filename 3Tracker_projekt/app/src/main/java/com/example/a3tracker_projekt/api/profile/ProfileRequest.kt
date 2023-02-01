package com.example.a3tracker_projekt.api.profile

import com.google.gson.annotations.SerializedName

data class ProfileRequest(
    @SerializedName("lastName")
    var lastName: String,
    @SerializedName("firstName")
    var firstName: String,
    @SerializedName("location")
    var location : String,
    @SerializedName("phoneNumber")
    var phoneNumber : String,
    @SerializedName("image")
    var image : String
)