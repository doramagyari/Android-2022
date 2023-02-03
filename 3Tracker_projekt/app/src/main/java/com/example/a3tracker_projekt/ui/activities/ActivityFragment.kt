package com.example.a3tracker_projekt.ui.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3tracker_projekt.repo.TrackerRepository
import com.example.projekt.R


class ActivityFragment : Fragment() {

    private lateinit var activityListViewModel: ActivityViewModel
    lateinit var list: ArrayList<Any>
    lateinit var adapter: ActivityAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ActivityViewModelFactory(TrackerRepository())
        activityListViewModel = ViewModelProvider(this, factory).get(ActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityListViewModel.readActivity()
        activityListViewModel.activity.observe(viewLifecycleOwner) {
            val activity = activityListViewModel.activity.value
            var recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            adapter = ActivityAdapter(activity!!, this)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
        }

    }

}


