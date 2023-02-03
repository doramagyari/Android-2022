package com.example.a3tracker_projekt.ui.tasks

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3tracker_projekt.api.tasks.TaskRequest
import com.example.a3tracker_projekt.api.tasks.TaskResult
import com.example.a3tracker_projekt.api.users.MyApplication
import com.example.a3tracker_projekt.api.users.MyUser
import com.example.a3tracker_projekt.repo.TrackerRepository
import com.example.a3tracker_projekt.ui.groups.Group
import kotlinx.coroutines.launch


class TaskViewModelFactory(
    private val repository: TrackerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel( repository) as T
    }
}

class TaskViewModel(val repository: TrackerRepository) : ViewModel() {
    var tasks = MutableLiveData<ArrayList<Task>>()
    var tasksInfo = ArrayList<TaskDetail>()
    var users1 = MutableLiveData<ArrayList<MyUser>>()
    var users2 = MutableLiveData<ArrayList<MyUser>>()
    var departments = MutableLiveData<ArrayList<Group>>()
    var currentTask: Task = Task(0, "", "", 0, 0, 0, "", 0, 0, 0, 0)
    var currentTaskInfo: TaskDetail = TaskDetail("", "", "")

    fun readTasks() {
        viewModelScope.launch {
            try {
                val response1 = repository.getUsers(MyApplication.token)
                if(response1.isSuccessful) {
                    users1.value = response1.body()
                    users2.value = response1.body()
                } else{
                    Log.i("xxx-uvm", response1.message())
                }
                val response2 = repository.getDepartments(MyApplication.token)
                if(response2.isSuccessful) {
                    departments.value = response2.body()
                } else{
                    Log.i("xxx-uvm", response1.message())
                }

                val response3 = repository.getMyTasks(MyApplication.token)
                if(response3.isSuccessful) {
                    tasks.value = response3.body()
                    for(i in tasks.value!!){
                        val currentCreated = users1.value?.find{ it.ID == i.created_by_user_ID}
                        val createdName = currentCreated?.first_name.plus(" ".plus(currentCreated?.last_name))
                        val currentAssigned = users2.value?.find{ it.ID == i.asigned_to_user_ID}
                        val assignedName = currentAssigned?.first_name.plus(" ".plus(currentAssigned?.last_name))
                        val currentDepartment = departments.value?.find{ it.ID == i.department_ID}
                        val departmentName = currentDepartment?.name.toString()
                        val currentTask = TaskDetail(createdName, assignedName, departmentName)
                        tasksInfo.add(currentTask)
                    }
                } else{
                    Log.i("xxx-uvm", response3.message())
                }
            } catch (e: Exception) {
                Log.i("xxx", e.toString())
            }
        }
    }

    fun getUsers(){
        viewModelScope.launch {
            try {
                val response1 = repository.getUsers(MyApplication.token)
                if(response1.isSuccessful) {
                    users1.value = response1.body()
                } else{
                    Log.i("xxx-uvm", response1.message())
                }
            } catch (e: Exception) {
                createTaskResult.value = TaskResult.UNKNOWN_ERROR
                Log.i("xxx", e.toString())
            }
        }
    }

    var createTaskResult: MutableLiveData<TaskResult> = MutableLiveData()

    fun createTask(request: TaskRequest){
        viewModelScope.launch {
            try {
                val response = repository.createTask(request, MyApplication.token)
                if (response.body()!!.message == "Success") {
                    createTaskResult.value = TaskResult.SUCCESS
                    Log.i("xxx", response.body().toString())
                } else {
                    createTaskResult.value = TaskResult.INVALID_INPUTS
                    Log.i("xxx", "Invalid inputs " + response.errorBody().toString()  )
                }
            } catch (e: Exception) {
                createTaskResult.value = TaskResult.UNKNOWN_ERROR
                Log.i("xxx", e.toString())
            }
        }
    }

}



//class TaskViewModel : ViewModel() {
//
//    var tasks: MutableList<Task> = mutableListOf()
//
//    fun retrievingTasks(){
//        var project = "projectName"
//        var title = "name"
//        var assignedBy = "valaki"
//        var assignee = "valami"
//        var priority = "priority"
//        var deadline = "2022.12.29"
//        var description = "description"
//        val newTask = Task(title, project, assignedBy, Date(), assignee, Date(), priority, description)
//    }
//
//    fun randomizeTasks(){
//        tasks.shuffle()
////        randomizeAnswers()
//    }
//
//    //like in the quiz
//    fun getTasks(x : Int) : Task{
//        return tasks[x];
//    }
//
//}

