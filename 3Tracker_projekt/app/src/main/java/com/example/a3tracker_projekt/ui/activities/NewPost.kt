package com.example.a3tracker_projekt.ui.activities

import java.util.*

data class NewPost(
    var user: String,
    var date: Date,
    val postType: PostType
)