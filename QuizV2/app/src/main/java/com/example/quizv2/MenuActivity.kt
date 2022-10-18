package com.example.quizv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quizv2.R.*

class MenuActivity : AppCompatActivity() {

    private lateinit var textUserName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_menu)

        textUserName = findViewById(id.the_text_name)

        val textName = intent.getStringExtra("Name of the player is : ")

        textUserName.text = "Name of the player is : "+textName
    }
}