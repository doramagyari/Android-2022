package com.example.quizv2.ui_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import com.example.quizv2.R
import com.example.quizv2.R.*

class MenuActivity : AppCompatActivity() {

    //elso megoldas

    /*
    private lateinit var textUserName : TextView
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_menu)

        /*
        textUserName = findViewById(id.the_text_name)

        val textName = intent.getStringExtra("Name of the player is : ")

        textUserName.text = "Name of the player is : "+textName
         */

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        findViewById<TextView>(R.id.the_text_name).apply {
            text = message
        }
    }
}