package com.example.a3tracker_projekt.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a3tracker_projekt.api.user.Archive
import com.example.a3tracker_projekt.ui.shared.ProfileViewModel
import com.example.a3tracker_projekt.ui.shared.ProfileViewModelFactory
import com.example.projekt.R

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.Date

class ProfileFragment : Fragment() {

//    private val sharedViewModel: ProfileViewModel by activityViewModels()
//    lateinit var logOutButton: Button
//    lateinit var username: TextView
//    lateinit var email: TextView
//    lateinit var address: TextView
//    lateinit var roleType: TextView
//    lateinit var job: TextView
//    lateinit var location: TextView
//    lateinit var startDate: TextView
//    lateinit var description: TextView

    private lateinit var userListViewModel: ProfileViewModel
    lateinit var logOutButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ProfileViewModelFactory(Archive())
        userListViewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
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
        val username: TextView = view.findViewById(R.id.profileUser)
        val email: TextView = view.findViewById(R.id.profileEmail)
        val address: TextView = view.findViewById(R.id.profileAddress)
        val roleType: TextView = view.findViewById(R.id.profileRoleType)
        val phone: TextView = view.findViewById(R.id.profilePhoneNumber)
        val profilePic: ImageView = view.findViewById(R.id.imageView)
        userListViewModel.readUsers()
        userListViewModel.user.observe(viewLifecycleOwner) {
            val user = userListViewModel.user.value
            username.text = user!!.first_name.plus(" ".plus(user.last_name))
            email.text = user.email
            address.text = user.location
            roleType.text = user.type.toString()
            phone.text = user.phone_number
            Glide.with(this)
                .load(user.imageUrl)
                .apply(RequestOptions().override(600, 200))
                .circleCrop()
                .into(profilePic)
            Log.i("xxx", user.toString())
        }
    }

    private fun registerListeners() {
        logOutButton.setOnClickListener {
            findNavController().navigate(R.id.navigation_login)
        }
    }

    private fun initViewItems(view: View) {
        logOutButton = view.findViewById(R.id.logOut)
//        username = view.findViewById(R.id.profileUser)
//        email = view.findViewById(R.id.profileEmail)
//        address = view.findViewById(R.id.profileAddress)
//        roleType = view.findViewById(R.id.profileRoleType)
//        job = view.findViewById(R.id.profileJobDep)
//        location = view.findViewById(R.id.profileLocation)
//        startDate = view.findViewById(R.id.profileStartDate)
//        description = view.findViewById(R.id.profileDescription)
    }

}