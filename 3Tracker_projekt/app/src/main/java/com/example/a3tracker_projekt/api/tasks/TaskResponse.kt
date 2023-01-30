package com.example.a3tracker_projekt.api.tasks

import com.google.gson.annotations.SerializedName

data class TaskResponse (
    @SerializedName("message")
    var message : String
)