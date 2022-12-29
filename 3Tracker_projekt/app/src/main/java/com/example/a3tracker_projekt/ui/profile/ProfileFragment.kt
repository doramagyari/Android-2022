package com.example.a3tracker_projekt.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.a3tracker_projekt.ui.shared.ProfileViewModel
import com.example.projekt.R

class ProfileFragment : Fragment() {

    private val sharedViewModel: ProfileViewModel by activityViewModels()
    lateinit var logOutButton : Button
    lateinit var username : TextView
    lateinit var email : TextView
    lateinit var address : TextView
    lateinit var roleType : TextView
    lateinit var job : TextView
    lateinit var location : TextView
    lateinit var startDate : TextView
    lateinit var description : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


}