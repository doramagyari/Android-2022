package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val TAG : String = "MainActivity"
    lateinit var startButton: Button

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart() called.")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume() called.")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause() called.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart() called.")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop() called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy() called.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate() called.")
        initViewItem()
        registerListener()

    }

    private fun initViewItem() {
        startButton = findViewById(R.id.startButton)
    }

    private fun registerListener() {
        startButton.setOnClickListener{
            //handle click events
        }
    }
}