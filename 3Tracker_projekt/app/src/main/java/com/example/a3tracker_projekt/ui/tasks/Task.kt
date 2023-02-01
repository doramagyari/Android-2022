package com.example.a3tracker_projekt.ui.tasks

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Task(
    @SerializedName("ID")
    var ID: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("created_time")
    var created_time: Long,
    @SerializedName("created_by_user_ID")
    var created_by_user_ID: Int,
    @SerializedName("asigned_to_user_ID")
    var asigned_to_user_ID: Int,
    @SerializedName("priority")
    var priority: String,
    @SerializedName("deadline")
    var deadline: Int,
    @SerializedName("department_ID")
    var department_ID: Int,
    @SerializedName("status")
    var status: Int,
    @SerializedName("progress")
    var progress: Int
)
