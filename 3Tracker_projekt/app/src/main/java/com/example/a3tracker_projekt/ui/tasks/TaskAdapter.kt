package com.example.a3tracker_projekt.ui.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekt.R

interface OnItemClickListener{
    fun onInfoClick(position: Int)
}

class TaskAdapter(private val items: List<Task>, private val itemsInfo: ArrayList<TaskInfo>, private val listener: TaskFragment): RecyclerView.Adapter<TaskAdapter.CardViewHolder>() {

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val taskDepartment: TextView = itemView.findViewById(R.id.taskDepartment)
        val taskTitle: TextView = itemView.findViewById(R.id.taskTitle)
        val taskUserDate: TextView = itemView.findViewById(R.id.postDate)
        val taskAssignee: TextView = itemView.findViewById(R.id.postNewTask)
        val taskDeadline: TextView = itemView.findViewById(R.id.taskDeadline)
        val taskPriority: TextView = itemView.findViewById(R.id.taskStatus)
        val taskDescription: TextView = itemView.findViewById(R.id.postDescription)

        private val infoButton: Button = itemView.findViewById(R.id.infoButton)

        init {
            infoButton.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                when (p0!!.id) {
                    R.id.infoButton -> {
                        listener.onInfoClick(position)
                    }
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycleview_example_item,
            parent, false
        )
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = items[position]
        val currentItemInfo = itemsInfo[position]
        holder.taskDepartment.text = currentItemInfo.department
        holder.taskTitle.text = currentItem.title
        holder.taskUserDate.text = currentItemInfo.created_by_user.plus(", ".plus(
            currentItem.created_time.toString()))
        holder.taskAssignee.text = currentItemInfo.assigned_to_user
        holder.taskDeadline.text = currentItem.deadline.toString()
        holder.taskPriority.text = currentItem.priority.toString()
        holder.taskDescription.text = currentItem.description
//        holder.taskStatus.text = currentItem.status.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
