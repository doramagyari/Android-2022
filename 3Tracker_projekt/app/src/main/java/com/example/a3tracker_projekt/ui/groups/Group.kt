package com.example.a3tracker_projekt.ui.groups


import kotlin.collections.ArrayList

data class Group(
    var name: String,
    var members: ArrayList<com.example.a3tracker_projekt.ui.activities.Member>
)