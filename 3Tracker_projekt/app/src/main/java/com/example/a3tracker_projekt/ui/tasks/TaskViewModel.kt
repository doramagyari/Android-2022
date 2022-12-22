package com.example.a3tracker_projekt.ui.tasks

import androidx.lifecycle.ViewModel
import java.util.*

data class Task(
    var title: String,
    var project: String,
    val assigner: String,
    val assignedDate: Date,
    var assignee: String,
    var deadline: Date,
    var priority: String,
    var description: String
)

class TaskViewModel : ViewModel() {
    var project = "projectName"
    var title = "name"
    var assignedBy = "valaki"
    var assignee = "valami"
    var priority = "priority"
    var deadline = "2022.12.29"
    var description = "description"
    val newTask = Task(title, project, assignedBy, Date(), assignee, Date(), priority, description)


}