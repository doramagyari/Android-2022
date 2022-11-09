package com.example.quizv2.ui_fragments

import android.annotation.SuppressLint
import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import com.example.quizv2.R
import com.example.quizv2.shared.MyViewModel
import com.example.quizv2.ui_fragments.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //navigation drawer
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        lateinit var toggle : ActionBarDrawerToggle

        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            it.isChecked = true
            when(it.itemId){
                R.id.navigation_Home -> Navigation.findNavController(this, R.id.navigationView).navigate(R.id.home3)
                R.id.navigation_Quiz -> Navigation.findNavController(this, R.id.navigationView).navigate(R.id.startQuiz)
//                R.id.nav_list -> Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.quizListFrag)
//                R.id.nav_add -> Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.quizAddFrag)
            }
            true
        }
        //navigation
        navigationView.setNavigationItemSelectedListener{ menuItem ->
            menuItem.isChecked = true
            drawerLayout.close()
            when (menuItem.itemId) {
                R.id.navigation_Home -> {
                    replaceFragment(Home(),R.id.fragment_container)
                    return@setNavigationItemSelectedListener true
                }

                R.id.navigation_Quiz -> {
                    replaceFragment(StartQuiz(),R.id.fragment_container)
                    return@setNavigationItemSelectedListener true
                }

                R.id.navigation_Profile -> {
                    replaceFragment(Profile(),R.id.fragment_container)
                    return@setNavigationItemSelectedListener true
                }


                else -> {
                    replaceFragment(Home(),R.id.fragment_container)
                    return@setNavigationItemSelectedListener true
                }
            }
        }

    }

    fun replaceFragment(fragment: Fragment, containerId: Int, addToBackStack:Boolean = false){
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(containerId, fragment)
        when(addToBackStack){
            true -> {
                transaction.addToBackStack(null)
            }
            else -> {}
        }
        transaction.commit()
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