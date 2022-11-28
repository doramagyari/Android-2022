package com.example.quizv2.ui_fragments

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ToggleButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import com.example.quizv2.R
import com.example.quizv2.ui_fragments.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //navigation drawer
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //navigation
        navigationView.setNavigationItemSelectedListener {menuItem ->
            menuItem.isChecked = true
            drawerLayout.close()
            when (menuItem.itemId) {
                R.id.navigation_Home -> {
                    /*supportFragmentManager.commit {
                        replace(R.id.fragment_container, Home())
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }*/
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

                R.id.questionList -> {
                    replaceFragment(QuestionList(),R.id.fragment_container)
                    return@setNavigationItemSelectedListener true
                }

                R.id.createQuestion -> {
                    replaceFragment(CreateQuestion(),R.id.fragment_container)
                    return@setNavigationItemSelectedListener true
                }

                else -> {
                    replaceFragment(Home(),R.id.fragment_container)
                    return@setNavigationItemSelectedListener true
                }
            }
        }

    }

    fun replaceFragment(fragment: Fragment, containerId: Int, addToBackStack:Boolean = false, withAnimation:Boolean = false){
        val transaction = supportFragmentManager.beginTransaction()
/*        when(withAnimation){
            true -> {
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            }
        }*/
        transaction.replace(containerId, fragment)
        when(addToBackStack){
            true -> {
                transaction.addToBackStack(null)
            }
            else -> {}
        }
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)

    }
}