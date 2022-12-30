package com.example.a3tracker_projekt.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.a3tracker_projekt.ui.shared.ProfileViewModel
import com.example.projekt.R

class ProfileFragment : Fragment() {

    private val sharedViewModel: ProfileViewModel by activityViewModels()
    lateinit var logOutButton: Button
    lateinit var username: TextView
    lateinit var email: TextView
    lateinit var address: TextView
    lateinit var roleType: TextView
    lateinit var job: TextView
    lateinit var location: TextView
    lateinit var startDate: TextView
    lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            initViewItems(this)
            registerListeners()
        }
        sharedViewModel.setUpProfile()

        username.text = sharedViewModel.profile.user.name
        email.text = sharedViewModel.profile.email
        address.text = sharedViewModel.profile.address
        roleType.text = sharedViewModel.profile.roleType
        job.text =
            sharedViewModel.profile.user.job.plus(", ".plus(sharedViewModel.profile.user.department))
        location.text = sharedViewModel.profile.user.location
        startDate.text = "${sharedViewModel.profile.user.startDate}"
        description.text = sharedViewModel.profile.user.description
    }

    private fun registerListeners() {
        logOutButton.setOnClickListener {
            findNavController().navigate(R.id.navigation_login)
        }
    }

    private fun initViewItems(view: View) {
        logOutButton = view.findViewById(R.id.logOut)
        username = view.findViewById(R.id.profileUser)
        email = view.findViewById(R.id.profileEmail)
        address = view.findViewById(R.id.profileAddress)
        roleType = view.findViewById(R.id.profileRoleType)
        job = view.findViewById(R.id.profileJobDep)
        location = view.findViewById(R.id.profileLocation)
        startDate = view.findViewById(R.id.profileStartDate)
        description = view.findViewById(R.id.profileDescription)
    }

}