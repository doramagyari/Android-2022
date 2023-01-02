package com.example.a3tracker_projekt.ui.shared

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.api.user.Application
import com.example.a3tracker_projekt.api.user.Archive
import com.example.a3tracker_projekt.ui.login.LoginResult
import kotlinx.coroutines.launch

class DemoLoginViewModelFactory(
    private val archive: Archive
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DemoLoginViewModel(archive) as T
    }
}

class DemoLoginViewModel(val archive: Archive) : ViewModel() {

    var loginResult: MutableLiveData<LoginResult> = MutableLiveData()

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = archive.login(request)
                if (response.isSuccessful) {

                    Application.token = response.body()!!.token
                    Application.deadline = response.body()!!.deadline

                    loginResult.value = LoginResult.SUCCESS
                    Log.i("xxx", response.body().toString())
                } else {
                    loginResult.value = LoginResult.INVALID_CREDENTIALS
                    Log.i("xxx", "Invalid credentials " + response.errorBody().toString()  )
                }
            } catch (e: Exception) {
                loginResult.value = LoginResult.UNKNOWN_ERROR
                Log.i("xxx", e.toString())
            }
        }
    }
}