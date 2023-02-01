package com.example.a3tracker_projekt.ui.activities

import java.util.*

data class StatusChange(
    var title: String,
    var project: String,
    val assigner: String,
    val assignedDate: Date,
    var assignee: String,
    var deadline: Date,
    var priority: String,
    var description: String
)