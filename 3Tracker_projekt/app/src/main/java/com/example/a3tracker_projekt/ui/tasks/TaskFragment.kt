package com.example.a3tracker_projekt.ui.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projekt.R

class TaskFragment : Fragment() {

    private val sharedViewModel: TaskViewModel by activityViewModels()
    lateinit var list: ArrayList<Task>
    lateinit var addButton : ImageButton
    lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        sharedViewModel.retrievingTasks()
        list = sharedViewModel.tasks as ArrayList<Task>
        var recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        adapter = TaskAdapter(list, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
    }

    private fun registerListeners() {
        addButton.setOnClickListener{
            findNavController().navigate(R.id.createTask)
        }
    }

    private fun initViewItems(view: View) {
        addButton = view.findViewById(R.id.createTask)
    }

}