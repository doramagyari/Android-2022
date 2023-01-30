package com.example.a3tracker_projekt.api.tasks

import com.google.gson.annotations.SerializedName


data class TaskRequest(
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("assignedToUserId")
    var assigneeId : Int,
    @SerializedName("priority")
    var priority : Int,
    @SerializedName("deadline")
    var deadline : Long,
    @SerializedName("departmentId")
    var departmentId: Int,
    @SerializedName("status")
    var status : Int
)
