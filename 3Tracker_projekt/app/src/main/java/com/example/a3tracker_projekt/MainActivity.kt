package com.example.a3tracker_projekt

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.a3tracker_projekt.api.users.MyApplication
import com.example.projekt.R
import com.example.projekt.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val prefs = this.getPreferences(MODE_PRIVATE)
        val token = prefs.getString("token", "")
        val deadline = prefs.getLong("deadline", 0L)

        Log.i("xxx", "token: " + token)
        val isValid = true
        if (!token.equals("") && isValid) {
            MyApplication.token = token!!
            MyApplication.email = prefs.getString("email", "")!!
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_login) {
                navView.visibility = View.GONE
            } else {
                navView.visibility = View.VISIBLE
            }
        }
        navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.activityFragment -> {
                    navController.navigate(R.id.activityFragment)
                    true
                }
                R.id.taskFragment -> {
                    navController.navigate(R.id.taskFragment)
                    true
                }
                R.id.groupFragment -> {
                    navController.navigate(R.id.groupFragment)
                    true
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }

    }
}
