package com.example.a3tracker_projekt.ui.tasks

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3tracker_projekt.repo.TrackerRepository
import com.example.projekt.R


class TaskFragment : Fragment() {

    private lateinit var taskListViewModel: TaskViewModel
    lateinit var list: ArrayList<Task>
    lateinit var adapter: TaskAdapter
    lateinit var addButton : ImageButton
    lateinit var infoButton : Button

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
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            initViewItems(this)
            registerListeners()
        }
        taskListViewModel.readTasks()
        taskListViewModel.tasks.observe(viewLifecycleOwner) {
            val tasks = taskListViewModel.tasks.value
            list = tasks!!
            var recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
            adapter = TaskAdapter(tasks!!, taskListViewModel.tasksInfo, this)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
        }
    }

    fun onInfoClick(position: Int) {
        taskListViewModel.currentTask = taskListViewModel.tasks.value?.get(position)!!
        taskListViewModel.currentTaskInfo = taskListViewModel.tasksInfo[position]
//        findNavController().navigate(R.id.taskInfoFragment) --kulon fragment
        val builder = AlertDialog.Builder(this.context)
        val details: String =
            "Task Title: ${taskListViewModel.currentTask.title}\n" +
                    "Created Time: ${taskListViewModel.currentTask.created_time}\n" +
                    "Created By: ${taskListViewModel.currentTaskInfo.created_by_user}\n" +
                    "Assigned To: ${taskListViewModel.currentTaskInfo.assigned_to_user}\n" +
                    "Department: ${taskListViewModel.currentTaskInfo.department}\n" +
                    "Deadline: ${taskListViewModel.currentTask.deadline}\n" +
                    "Priority: ${taskListViewModel.currentTask.priority}\n" +
                    "Status: ${taskListViewModel.currentTask.status}\n" +
                    "Progress: ${taskListViewModel.currentTask.progress}\n" +
                    "Description: ${taskListViewModel.currentTask.description}\n"
        builder.setMessage(details)
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, id ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    private fun registerListeners() {
        addButton.setOnClickListener{
            findNavController().navigate(R.id.createTaskFragment)
        }
    }

    private fun initViewItems(view: View) {
        addButton = view.findViewById(R.id.addTask)
    }

}
