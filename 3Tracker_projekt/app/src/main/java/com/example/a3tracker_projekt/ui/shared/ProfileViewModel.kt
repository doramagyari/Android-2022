package com.example.a3tracker_projekt.ui.shared

import androidx.lifecycle.ViewModel
import com.example.a3tracker_projekt.ui.activities.Member
import java.util.*

data class Profile(
    var user: Member,
    var email: String,
    var address: String,
    var roleType: String
)

class ProfileViewModel : ViewModel() {




}