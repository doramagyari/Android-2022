package com.example.a3tracker_projekt.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a3tracker_projekt.api.profile.ProfileRequest
import com.example.a3tracker_projekt.api.profile.ProfileResult
import com.example.a3tracker_projekt.repo.TrackerRepository
import com.example.projekt.R

class UpdateProfile : Fragment() {

    var TAG = "UpdateProfile"
    private lateinit var userListViewModel: ProfileViewModel
    lateinit var firstName : EditText
    lateinit var lastName : EditText
    lateinit var location : EditText
    lateinit var phone : EditText
    lateinit var imageUrl : EditText
    lateinit var updateButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ProfileViewModelFactory(TrackerRepository())
        userListViewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            initViewItems(this)
            registerListeners()
        }
        userListViewModel.readUsers()
        userListViewModel.user.observe(viewLifecycleOwner) {
            val user = userListViewModel.user.value
//            editText.text = "${userList!!.size}"
            firstName.setText(user!!.first_name)
            lastName.setText(user.last_name)
            location.setText(user.location)
            phone.setText(user.phone_number)
            imageUrl.setText(user.image)
            Log.i("xxx", user.toString())
        }
    }

    private fun registerListeners() {
        updateButton.setOnClickListener {

            if (checkInputFor(firstName.text.toString()) ||
                checkInputFor(lastName.text.toString()) ||
                checkInputFor(location.text.toString()) ||
                checkInputFor(phone.text.toString()) ||
                checkInputFor(imageUrl.text.toString())) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.empty_name_error_message),
                    Toast.LENGTH_LONG
                ).show()
            } else {

                Log.i(TAG, "Updating Profile")

                userListViewModel.updateProfile(
                    ProfileRequest(
                        lastName.text.toString(),
                        firstName.text.toString(),
                        location.text.toString(),
                        phone.text.toString(),
                        imageUrl.text.toString())
                )
                userListViewModel.updateProfileResult.observe(viewLifecycleOwner) {
                    // Save data to preferences
                    if( it == ProfileResult.INVALID_INPUTS){
                        Toast.makeText(
                            this.requireContext(),
                            "Invalid inputs",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if ( it == ProfileResult.SUCCESS ) {
                        findNavController().navigate(R.id.profileFragment)
                    }
                }
            }
        }
    }

    private fun checkInputFor(text: String) = text.isEmpty()

    private fun initViewItems(view: View) {
        firstName = view.findViewById(R.id.updateFirstName)
        lastName = view.findViewById(R.id.updateLastName)
        location = view.findViewById(R.id.updateLocation)
        phone = view.findViewById(R.id.updatePhone)
        imageUrl = view.findViewById(R.id.updateProfilePic)
        updateButton = view.findViewById(R.id.updateProfile)
    }

}