package com.example.a3tracker_projekt.ui.activities

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.users.MyApplication
import com.example.a3tracker_projekt.api.users.TrackerRepository
import kotlinx.coroutines.launch
import java.util.ArrayList

class ActivityViewModelFactory(
    private val repository: TrackerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ActivityViewModel( repository) as T
    }
}

class ActivityViewModel(val repository: TrackerRepository) : ViewModel() {
    var activity = MutableLiveData<ArrayList<Any>>()

    fun readActivity() {
        viewModelScope.launch {
            try {
                val response = repository.getActivities(MyApplication.token)
                if(response.isSuccessful) {
                    activity.value = response.body()
                } else{
                    Log.i("xxx-uvm", response.message())
                }
            } catch (e: Exception) {
                Log.i("xxx", e.toString())
            }
        }
    }


}