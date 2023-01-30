package com.example.a3tracker_projekt.api.users

import android.app.Application

class MyApplication : Application() {
    companion object {
        var token: String = ""
        var deadline: Long = 0L
        var email: String = ""
    }
}