package com.example.a3tracker_projekt.ui.shared

import androidx.lifecycle.ViewModel
import com.example.a3tracker_projekt.ui.activities.Member
import com.example.a3tracker_projekt.ui.groups.Group
import java.util.*
import kotlin.collections.ArrayList

class GroupViewModel : ViewModel() {

    var groups: MutableList<Group> = mutableListOf()

    fun setUpGroups(){

        val groupName = "groupname"

        val name1 = "name1"
        val name2 = "name2"
        val name3 = "name3"
        val job = "job"
        val department = "department"
        val location = "location"
        val startDate = Date()
        val description = "description"

        val member1 = Member(name1, job, department, location, startDate, description)
        val member2 = Member(name2, job, department, location, startDate, description)
        val member3 = Member(name3, job, department, location, startDate, description)

        var members : ArrayList<Member> = arrayListOf<Member>(member1, member2, member3)
        val newGroup = Group(groupName, members)
        groups.add(newGroup)


    }

    fun getGroup(n: Int) : Group{
        return groups[n]
    }


}