package com.example.a3tracker_projekt.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a3tracker_projekt.api.users.TrackerRepository
import com.example.projekt.R

class TaskInfoFragment : Fragment() {

    private lateinit var taskListViewModel: TaskViewModel
    private lateinit var title: TextView
    private lateinit var createdTime: TextView
    private lateinit var creator: TextView
    private lateinit var assignee: TextView
    private lateinit var department: TextView
    private lateinit var deadline: TextView
    private lateinit var priority: TextView
    private lateinit var status: TextView
    private lateinit var progress: TextView
    private lateinit var description: TextView
    private lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TaskViewModelFactory(TrackerRepository())
        taskListViewModel = ViewModelProvider(this, factory).get(TaskViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            initViewItems(this)
            registerListeners()
        }
        title.text = taskListViewModel.currentTask.title
        createdTime.text = taskListViewModel.currentTask.created_time.toString()
        creator.text = taskListViewModel.currentTaskInfo.created_by_user
        assignee.text = taskListViewModel.currentTaskInfo.assigned_to_user
        department.text = taskListViewModel.currentTaskInfo.department
        deadline.text = taskListViewModel.currentTask.deadline.toString()
        priority.text = taskListViewModel.currentTask.priority.toString()
        status.text = taskListViewModel.currentTask.status.toString()
        progress.text = taskListViewModel.currentTask.progress.toString()
        description.text = taskListViewModel.currentTask.description
    }

    private fun registerListeners() {
        backButton.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    private fun initViewItems(view: View) {
        title = view.findViewById(R.id.taskInfoTitle)
        createdTime = view.findViewById(R.id.taskInfoTime)
        creator = view.findViewById(R.id.taskInfoCreator)
        assignee = view.findViewById(R.id.taskInfoAssignee)
        department = view.findViewById(R.id.taskInfoDepartment)
        deadline = view.findViewById(R.id.taskInfoDeadline)
        priority = view.findViewById(R.id.taskInfoPriority)
        status = view.findViewById(R.id.taskInfoStatus)
        progress = view.findViewById(R.id.taskInfoProgress)
        description = view.findViewById(R.id.taskInfoDescription)
        backButton = view.findViewById(R.id.backButton)
    }

}