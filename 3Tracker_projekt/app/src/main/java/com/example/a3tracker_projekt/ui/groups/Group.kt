package com.example.a3tracker_projekt.ui.groups

import com.example.a3tracker_projekt.api.users.MyUser
import com.example.a3tracker_projekt.ui.activities.Member
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Group(
    @SerializedName("ID")
    var ID: Int,
    @SerializedName("name")
    var name: String,
    var members: ArrayList<MyUser>
)