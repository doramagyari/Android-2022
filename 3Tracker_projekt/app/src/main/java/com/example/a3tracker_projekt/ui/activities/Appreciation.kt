package com.example.a3tracker_projekt.ui.activities

import java.util.*

data class Appreciation(
    var user: String,
    var date: Date,
//    val profilePic: String,
    val assignedDate: Date,
    var assignee: String,
    var deadline: Date,
    var priority: String,
    var description: String
)