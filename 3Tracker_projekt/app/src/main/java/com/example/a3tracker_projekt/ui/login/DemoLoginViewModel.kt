package com.example.a3tracker_projekt.ui.shared

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.api.users.MyApplication
import com.example.a3tracker_projekt.api.users.TrackerRepository
import com.example.a3tracker_projekt.ui.login.LoginResult
import kotlinx.coroutines.launch

class DemoLoginViewModelFactory(
    private val archive: TrackerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DemoLoginViewModel(archive) as T
    }
}

class DemoLoginViewModel(val archive: TrackerRepository) : ViewModel() {

    var loginResult: MutableLiveData<LoginResult> = MutableLiveData()

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = archive.login(request)
                if (response.isSuccessful) {

                    MyApplication.token = response.body()!!.token
                    MyApplication.deadline = response.body()!!.deadline

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