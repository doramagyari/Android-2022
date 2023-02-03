package com.example.a3tracker_projekt.ui.profile

import com.example.a3tracker_projekt.ui.activities.Member

data class Profile(
    var user: Member,
    var email: String,
    var address: String,
    var roleType: String
)

