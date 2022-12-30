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
    var profile: Profile = Profile(Member("", "", "", "", Date(), ""), "", "", "")

    fun setUpProfile(){

        val name = "name"
        val job = "job"
        val department = "department"
        val location = "location"
        val startDate = Date()
        val description = "description"
        val member = Member(name, job, department, location, startDate, description)
        profile.user = member
        profile.email = "email@gmail.com"
        profile.address = "address"
        profile.roleType = "managment"

    }



}