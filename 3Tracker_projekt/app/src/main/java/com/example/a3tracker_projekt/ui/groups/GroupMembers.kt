package com.example.a3tracker_projekt.ui.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3tracker_projekt.api.users.MyUser
import com.example.projekt.R

class GroupMembers(private val members: List<MyUser>) :
    RecyclerView.Adapter<GroupMembers.GroupMemberViewHolder>() {

    inner class GroupMemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memberName: TextView = itemView.findViewById(R.id.memberName)
        val memberPic: ImageView = itemView.findViewById(R.id.memberProfilePic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupMemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_item_group_member, parent, false)
        return GroupMemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupMemberViewHolder, position: Int) {
//        Glide.with(this)
//            .load(members[position].imageUrl)
//            .apply(RequestOptions().override(60, 20))
//            .circleCrop()
//            .into(holder.memberPic)
        holder.memberName.text = members[position].first_name.plus(" ".plus(members[position].last_name))
    }

    override fun getItemCount(): Int {
        return members.size
    }

}