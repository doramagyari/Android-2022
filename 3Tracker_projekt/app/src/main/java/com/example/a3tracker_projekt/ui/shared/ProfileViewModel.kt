package com.example.a3tracker_projekt.ui.shared

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.profile.ProfileRequest
import com.example.a3tracker_projekt.api.user.Application
import com.example.a3tracker_projekt.api.user.Archive
import com.example.a3tracker_projekt.api.user.User
import com.example.a3tracker_projekt.ui.profile.ProfileResult
import kotlinx.coroutines.launch
import java.util.*

class ProfileViewModelFactory(
    private val archive: Archive
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel( archive) as T
    }
}

class ProfileViewModel(val archive: Archive) : ViewModel() {
    var user = MutableLiveData<User>()

    fun readUsers() {
        viewModelScope.launch {
            try {
                val response = archive.getMyUser(Application.token)
                if(response.isSuccessful) {
                    user.value = response.body()
                } else{
                    Log.i("xxx-uvm", response.message())
                }
            } catch (e: Exception) {
                Log.i("xxx", e.toString())
            }
        }
    }

    


}