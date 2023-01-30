package com.example.a3tracker_projekt.ui.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projekt.R

class GroupAdapter(private val groups: List<Group>) :
    RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

    inner class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groupName: TextView = itemView.findViewById(R.id.groupName)
        val memberRecyclerView: RecyclerView = itemView.findViewById(R.id.recyclerViewGroup)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_item_group, parent, false)
        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val currentItem = groups[position]
        holder.groupName.text = currentItem.name.toString()
    }

    override fun getItemCount(): Int {
        return groups.size
    }
}