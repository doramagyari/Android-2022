package com.example.a3tracker_projekt.ui.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekt.R

class GroupMembers(private val members: ArrayList<com.example.a3tracker_projekt.ui.activities.Member>) :
    RecyclerView.Adapter<GroupMembers.GroupMembersViewHolder>() {

    inner class GroupMembersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memberName: TextView = itemView.findViewById(R.id.memberName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupMembersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_item_group_member, parent, false)
        return GroupMembersViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupMembersViewHolder, position: Int) {
//        holder.logo.setImageResource(childList[position].logo)
        holder.memberName.text = members[position].name
    }

    override fun getItemCount(): Int {
        return members.size
    }

}