package com.example.a3tracker_projekt.ui.activities

import com.example.a3tracker_projekt.api.users.MyUser
import com.google.gson.annotations.SerializedName

data class NewMember(
    @SerializedName("ID")
    var ID: Int,
    @SerializedName("type")
    var type: Int,
    @SerializedName("created_by_user_id")
    var created_by_user_id: Int,
    @SerializedName("sub_type")
    var sub_type: Int,
    @SerializedName("created_time")
    var created_time: Long,
    @SerializedName("sub_ID")
    var sub_ID: Int,
    @SerializedName("sub_user_ID")
    var sub_user_ID: Int,
    @SerializedName("note")
    var note: String,
    @SerializedName("progress")
    var progress: Int,
//    val profilePic: String,
    val newMember: MyUser
)