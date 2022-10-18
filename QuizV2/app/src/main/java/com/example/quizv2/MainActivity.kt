package com.example.quizv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var editName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editName = findViewById(R.id.text_name)

        button.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java)
                .putExtra("Name of the player is : ",editName.text.toString()))
        }
    }
}