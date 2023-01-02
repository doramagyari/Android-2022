package com.example.a3tracker_projekt.api.user

import android.app.Application

class Application : Application() {
    companion object {
        var token: String = ""
        var deadline: Long = 0L
        var email: String = ""
    }
}