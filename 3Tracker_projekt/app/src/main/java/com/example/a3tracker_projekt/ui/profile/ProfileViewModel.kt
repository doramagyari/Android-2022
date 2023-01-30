package com.example.a3tracker_projekt.ui.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.users.MyApplication
import com.example.a3tracker_projekt.api.users.TrackerRepository
import com.example.a3tracker_projekt.api.users.MyUser
import kotlinx.coroutines.launch

class ProfileViewModelFactory(
    private val repository: TrackerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel( repository) as T
    }
}

class ProfileViewModel(val repository: TrackerRepository) : ViewModel() {
    var user = MutableLiveData<MyUser>()

    fun readUsers() {
        viewModelScope.launch {
            try {
                val response = repository.getMyUser(MyApplication.token)
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