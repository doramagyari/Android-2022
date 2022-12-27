package com.example.a3tracker_projekt.ui.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekt.R

class TaskAdapter(private val tasks: List<Task>, private val mOnProductClickListener: TaskFragment) : RecyclerView.Adapter<TaskAdapter.RecyclerViewViewHolder>() {

    inner class RecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val ProjektTypeTask : TextView = itemView.findViewById(R.id.ProjectTypeTask)
        val TaskName : TextView = itemView.findViewById(R.id.TaskName)
        val AssigneeTask : TextView = itemView.findViewById(R.id.AssigneeTask)
        val UserAndDateOfPosting : TextView = itemView.findViewById(R.id.UserAndDateOfPosting)
        val DeadlineOfTask : TextView = itemView.findViewById(R.id.DeadlineOfTask)
        val TitleOfTask : TextView = itemView.findViewById(R.id.TitleOfTask)
        val DescriptionOfTask : TextView = itemView.findViewById(R.id.DescriptionOfTask)
        val PriorityOftask : TextView = itemView.findViewById(R.id.PriorityOftask)

//        val detailsButton : Button = itemView.findViewById(R.id.detailsButton)
//        val deleteButton : Button = itemView.findViewById(R.id.deleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_example_item,parent,false)
        val holder = RecyclerViewViewHolder(itemView)

        // to see details
//        holder.detailsButton.setOnClickListener {
//            val position = holder.adapterPosition
//            val model = tasks[position]
//            mOnProductClickListener.onDetails(model)
//        }

//        //delete item from recycler view
//        holder.deleteButton.setOnClickListener {
//            val position = holder.adapterPosition
//            val model = tasks[position]
//            mOnProductClickListener.onDelete(model)
//        }
        return holder
    }


    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        val currentItem = tasks[position]

        holder.ProjektTypeTask.text = currentItem.project
        holder.TitleOfTask.text = currentItem.title
        holder.AssigneeTask.text = currentItem.assignee
        holder.DeadlineOfTask.text = currentItem.deadline.toString()
        holder.UserAndDateOfPosting.text = currentItem.assigner.plus(" ".plus(currentItem.assignedDate))
        holder.PriorityOftask.text = currentItem.priority
        holder.DescriptionOfTask.text = currentItem.description

//from quiz
//        var numberOfCorrectAnswers = 0
//        var textOfTheCorrectAnswer = ""
//        for(q in currentItem.answers){
//            if(q.second) {
//                numberOfCorrectAnswers++
//                textOfTheCorrectAnswer = q.first
//            }
//        }


    }

    override fun getItemCount(): Int = tasks.size

//    fun removeProduct(model: Task) {
//        val position = tasks.indexOf(model)
//        tasks.remove(model)
//        notifyItemRemoved(position)
//    }
}

interface OnQuestionClickListener {

    /**
     * when the user clicks on delete icon this method will be invoked to remove item at position.
     */
    fun onDelete(model: Task)
    /**
     * when the user clicks on details icon this method will be invoked to show details about the item at position.
     */
    fun onDetails(model: Task)
}
