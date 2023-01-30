package com.example.a3tracker_projekt.ui.tasks

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class CreatingTask(
    var created_by_user: String,
    var assigned_to_user: String,
    var department: String
)