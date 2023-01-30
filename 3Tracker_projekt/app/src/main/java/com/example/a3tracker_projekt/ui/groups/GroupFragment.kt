package com.example.a3tracker_projekt.ui.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3tracker_projekt.api.users.TrackerRepository
import com.example.projekt.R


class GroupFragment : Fragment() {

    private lateinit var groupListViewModel: GroupViewModel
    lateinit var list: ArrayList<Group>
    lateinit var adapter: GroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = GroupViewModelFactory(TrackerRepository())
        groupListViewModel = ViewModelProvider(this, factory).get(GroupViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        groupListViewModel.readGroups()
        groupListViewModel.groups.observe(viewLifecycleOwner) {
            val groups = groupListViewModel.groups.value
            list = groups!!
            for (i in list){
                groupListViewModel.readGroupMembers(i.ID)
                val members = groupListViewModel.members.value
                if (members != null) {
                    i.members = members
                }
            }
            var recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            adapter = GroupAdapter(list)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
        }
    }

}