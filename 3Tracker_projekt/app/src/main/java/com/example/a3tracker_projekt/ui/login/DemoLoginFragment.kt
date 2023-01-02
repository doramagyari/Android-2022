package com.example.a3tracker_projekt.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.api.user.Application
import com.example.a3tracker_projekt.api.user.Archive
import com.example.a3tracker_projekt.ui.shared.DemoLoginViewModel
import com.example.a3tracker_projekt.ui.shared.DemoLoginViewModelFactory
import com.example.projekt.R
import com.example.projekt.databinding.FragmentDemoLoginBinding

class DemoLoginFragment : Fragment() {

//    private var _binding: FragmentDemoLoginBinding? = null
//
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val demoLoginViewModel =
//            ViewModelProvider(this).get(DemoLoginViewModel::class.java)
//        _binding = FragmentDemoLoginBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val navController = findNavController()
//
//
//
//        binding.projectDemoLoginButton.setOnClickListener {
//            demoLoginViewModel.login(
//                binding.projectDemoEmail.text.toString(),
//                binding.projectDemoPassword.text.toString()
//            )
//            demoLoginViewModel.loginResult.observe(viewLifecycleOwner) {
//                if (it == LoginResult.LOADING) {
//                    return@observe
//                }
//                Toast.makeText(activity, it.toString(), Toast.LENGTH_LONG).show()
//                if (it == LoginResult.SUCCESS) {
//                    navController.navigate(R.id.profileFragment)
//                } else {
//                    navController.navigate(R.id.navigation_login)
//                }
//            }
//        }
//        return root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    private lateinit var DemologinViewModel: DemoLoginViewModel
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = DemoLoginViewModelFactory(Archive())
        DemologinViewModel = ViewModelProvider(this, factory).get(DemoLoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText1 = view.findViewById(R.id.project_demo_email)
        editText2 = view.findViewById(R.id.project_demo_password)
        button= view.findViewById(R.id.login_button)

        val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
        if (!prefs.getString("email", "").equals("")) {
            editText1.setText(prefs.getString("email", ""))
        }

        button.setOnClickListener {
            val email = editText1.text.toString().trim()
            val password = editText2.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this.requireContext(),
                    "Please, enter your email and password",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                DemologinViewModel.login(LoginRequest(email, password))
            }
        }

        DemologinViewModel.loginResult.observe(viewLifecycleOwner) {
            // Save data to preferences
            if( it == LoginResult.INVALID_CREDENTIALS){
                Toast.makeText(
                    this.requireContext(),
                    "Invalid credentials",
                    Toast.LENGTH_LONG
                ).show()
            }
            if ( it == LoginResult.SUCCESS ) {
                val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
                val edit = prefs.edit()
                edit.putString("token", Application.token)
                edit.putLong("deadline", Application.deadline)
                edit.putString("email", editText1.text.toString())
                edit.apply()
                findNavController().navigate(R.id.profileFragment)
            }
        }

    }


}