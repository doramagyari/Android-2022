package com.example.a3tracker_projekt.ui.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekt.R

class ActivityAdapter(private val items: List<Any>, private val listener: ActivityFragment): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val NEW_MEMBER = 1
        const val NEW_TASK = 2
    }

    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val postName: TextView = itemView.findViewById(R.id.postUser)
        val postDate: TextView = itemView.findViewById(R.id.postDate)
        val postPic: ImageView = itemView.findViewById(R.id.postNewPic)
        val postNewMember: TextView = itemView.findViewById(R.id.postNewTask)
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val postName: TextView = itemView.findViewById(R.id.user)
        val postDate: TextView = itemView.findViewById(R.id.date)
//        val postPic: ImageView = itemView.findViewById(R.id.postProfilePic)
        val postNewTask: TextView = itemView.findViewById(R.id.postingNewTask)
        val postProject: TextView = itemView.findViewById(R.id.ProjectTypeTask)
        val postTitle: TextView = itemView.findViewById(R.id.TitleOfTask)
        val postUserDate: TextView = itemView.findViewById(R.id.UserAndDateOfPosting)
        val postAssignee: TextView = itemView.findViewById(R.id.AssigneeTask)
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == NEW_MEMBER) {
            MemberViewHolder(
                LayoutInflater.from(parent.context).inflate(
                R.layout.new_item,
                parent, false
            ))
        } else{
            TaskViewHolder(
                LayoutInflater.from(parent.context).inflate(
                R.layout.new_task_to_activities,
                parent, false
            ))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MemberViewHolder -> {
                val cr = items[position] as NewMember
                holder.postName.text = cr.created_by_user_id.toString()
                holder.postDate.text = cr.created_time.toString()
                holder.postNewMember.text = cr.newMember.first_name.plus(" ".plus(cr.newMember.last_name))
//                Glide.with(this)
//                    .load(cr.newMember.imageUrl)
//                    .apply(RequestOptions().override(600, 200))
//                    .circleCrop()
//                    .into(holder.postPic)
            }
            is TaskViewHolder -> {
//                val cr = items[position] as NewTask
//                holder.postName.text = cr.created_by_user_id.toString()
//                holder.postDate.text = cr.created_time.toString()
////                Glide.with(this)
////                    .load(cr.imageUrl)
////                    .apply(RequestOptions().override(600, 200))
////                    .circleCrop()
////                    .into(holder.postPic)
//                holder.postNewTask.text = cr.newTask.title
////                holder.postProject.text = cr.newTask.project
//                holder.postTitle.text = cr.newTask.title
////                holder.postUserDate.text = cr.newTask.assigner.plus(" ".plus(cr.newTask.assignedDate))
////                holder.postAssignee.text = cr.newTask.assignee
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is NewMember -> NEW_MEMBER
            else -> NEW_TASK
        }
    }

}