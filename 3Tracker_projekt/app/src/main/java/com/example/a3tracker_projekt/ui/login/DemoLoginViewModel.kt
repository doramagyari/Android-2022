package com.example.a3tracker_projekt.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.repo.UserRepository
import kotlinx.coroutines.launch

class DemoLoginViewModel : ViewModel() {

    companion object{
        val TAG: String = DemoLoginViewModel::class.java.simpleName
    }

    val loginResult: MutableLiveData<LoginResult> = MutableLiveData()
    private val userRepo = UserRepository()

    fun login(email: String, password: String) {
        loginResult.value = LoginResult.LOADING
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            loginResult.value = LoginResult.INVALID_CREDENTIALS
            return
        }
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(email, password)
                val response = userRepo.loginUser(loginRequest = loginRequest)
                if (response?.isSuccessful == true) {
                    Log.d(TAG, "Login response ${response.body()}")
                    loginResult.value = LoginResult.SUCCESS
                } else {
                    Log.d(TAG, "Login error response ${response?.errorBody()}")
                    loginResult.value = LoginResult.INVALID_CREDENTIALS
                }

            } catch (ex: Exception) {
                Log.e(TAG, ex.message, ex)
                loginResult.value = LoginResult.UNKNOWN_ERROR
            }
        }
    }
}