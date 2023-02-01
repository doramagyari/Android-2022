package com.example.a3tracker_projekt.ui.tasks

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a3tracker_projekt.api.tasks.TaskRequest
import com.example.a3tracker_projekt.api.tasks.TaskResult
import com.example.a3tracker_projekt.api.users.TrackerRepository
import com.example.projekt.R

class CreateTaskFragment : Fragment() {

    var TAG = "CreateTaskFragment"
    private lateinit var taskListViewModel: TaskViewModel
    lateinit var project: EditText
    lateinit var name: EditText
    lateinit var assignee: EditText
    lateinit var priority: EditText
    lateinit var deadline: EditText
    lateinit var department: EditText
    lateinit var status: EditText
    lateinit var description: EditText
    lateinit var createButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TaskViewModelFactory(TrackerRepository())
        taskListViewModel = ViewModelProvider(this, factory).get(TaskViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            initViewItems(this)
            registerListeners()
        }
    }

    private fun registerListeners() {
        createButton.setOnClickListener {

            taskListViewModel.getUsers()

            var users = taskListViewModel.users1.value

            if (checkInputFor(name.text.toString()) ||
                checkInputFor(description.text.toString()) ||
                checkInputFor(assignee.text.toString()) ||
                checkInputFor(priority.text.toString()) ||
                checkInputFor(deadline.text.toString()) ||
                checkInputFor(department.text.toString()) ||
                checkInputFor(status.text.toString())
            ) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.empty_name_error_message),
                    Toast.LENGTH_LONG
                ).show()
            } else {

                Log.i(TAG, "Adding Task")

                taskListViewModel.createTask(
                    TaskRequest(
                        name.text.toString(),
                        description.text.toString(),
                        assignee.text.toString().toInt(),
                        priority.text.toString().toInt(),
                        deadline.text.toString().toLong(),
                        department.text.toString().toInt(),
                        status.text.toString().toInt()
                    )
                )
                taskListViewModel.createTaskResult.observe(viewLifecycleOwner) {
                    // Save data to preferences
                    if (it == TaskResult.INVALID_INPUTS) {
                        Toast.makeText(
                            this.requireContext(),
                            "Invalid inputs",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (it == TaskResult.SUCCESS) {
                        findNavController().navigate(R.id.taskFragment)
                    }
                }
            }
        }
    }

    private fun checkInputFor(text: String) = text.isEmpty()

    private fun initViewItems(view: View) {
        name = view.findViewById(R.id.addName)
        assignee = view.findViewById(R.id.addAssignee)
        priority = view.findViewById(R.id.addPriority)
        deadline = view.findViewById(R.id.addDeadline)
        department = view.findViewById(R.id.addDepartment)
        status = view.findViewById(R.id.addStatus)
        description = view.findViewById(R.id.addDescription)
        createButton = view.findViewById(R.id.createTask)
    }
}

