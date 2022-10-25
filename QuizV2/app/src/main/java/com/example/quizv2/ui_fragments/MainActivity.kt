package com.example.quizv2.ui_fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.quizv2.R
import com.example.quizv2.shared.MyViewModel
import com.google.android.material.snackbar.Snackbar

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    val viewModel : MyViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}

/*
class MainActivity : AppCompatActivity() {

    val REQUEST_SELECT_CONTACT = 1
    lateinit var contactUri: Uri

    //elso megoldas

    /* private lateinit var button : Button
    private lateinit var editName : EditText
    */

    private lateinit var button: Button
    private lateinit var editName: EditText
    private lateinit var contactsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        button = findViewById(R.id.button)
        editName = findViewById(R.id.text_name)

        button.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java)
                .putExtra("Name of the player is : ",editName.text.toString()))
        }
        */

        val button = findViewById<Button>(R.id.button)
        val editName = findViewById<EditText>(R.id.text_name)

        button.setOnClickListener {
            if (editName.text.isEmpty()) {
                Toast.makeText(applicationContext, "You did not give a name!", Toast.LENGTH_SHORT).show();
//                val intent = Intent(this, MenuActivity::class.java).apply {
//                    putExtra(EXTRA_MESSAGE, "You didn't give any name!")
//                }
//                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext, "Your name: ${editName.text}", Toast.LENGTH_SHORT).show();
//                val intent = Intent(this, MenuActivity::class.java).apply {
//                    putExtra(EXTRA_MESSAGE, "Name of the player is :  ${editName.text}")
//                }
//                startActivity(intent)
            }
        }



        val contactsButton = findViewById<Button>(R.id.contactsButton)

        contactsButton.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)

            intent.type = ContactsContract.Contacts.CONTENT_TYPE

            startActivityForResult(intent, REQUEST_SELECT_CONTACT)
        }

    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_SELECT_CONTACT && resultCode == Activity.RESULT_OK){
            contactUri = data!!.data!!
            getContactName()
        }
    }

    @SuppressLint("Range")
    private fun getContactName() {
        val cursor = contentResolver.query(contactUri,null,null,null,null)

        if(cursor!!.moveToFirst()){
            val contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))

            val editName = findViewById<EditText>(R.id.text_name)
            editName.setText(contactName)

        }
    }
}
*/