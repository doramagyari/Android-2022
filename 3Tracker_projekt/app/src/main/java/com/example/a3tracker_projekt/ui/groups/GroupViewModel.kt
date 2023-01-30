package com.example.a3tracker_projekt.ui.groups

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.users.MyApplication
import com.example.a3tracker_projekt.api.users.MyUser
import com.example.a3tracker_projekt.api.users.TrackerRepository
import kotlinx.coroutines.launch

class GroupViewModelFactory(
    private val repository: TrackerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroupViewModel( repository) as T
    }
}

class GroupViewModel(val repository: TrackerRepository) : ViewModel() {
    var groups = MutableLiveData<ArrayList<Group>>()
    var members = MutableLiveData<ArrayList<MyUser>>()

    fun readGroups() {
        viewModelScope.launch {
            try {
                val response = repository.getDepartments(MyApplication.token)
                if (response.isSuccessful) {
                    groups.value = response.body()
                } else {
                    Log.i("xxx-uvm", response.message())
                }
            } catch (e: Exception) {
                Log.i("xxx", e.toString())
            }
        }
    }

    fun readGroupMembers(group: Int) {

        viewModelScope.launch {
            try {
                val response = repository.getDepartmentMembers(MyApplication.token, group)
                if (response.isSuccessful) {
                    members.value = response.body()
                } else {
                    Log.i("xxx-uvm", response.message())
                }
            } catch (e: Exception) {
                Log.i("xxx", e.toString())
            }
        }
    }

}