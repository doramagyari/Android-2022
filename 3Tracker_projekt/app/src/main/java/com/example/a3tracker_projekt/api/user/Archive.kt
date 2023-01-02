package com.example.a3tracker_projekt.api.user

import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.api.login.LoginResponse
import com.example.a3tracker_projekt.api.profile.ProfileRequest
import com.example.a3tracker_projekt.api.profile.ProfileResponse
import com.example.a3tracker_projekt.api.task.TaskRequest
import com.example.a3tracker_projekt.api.task.TaskResponse
import com.example.a3tracker_projekt.ui.groups.Group
import com.example.a3tracker_projekt.ui.tasks.Task
import retrofit2.Response

class Archive {

    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return RetrofitInstance.api.login(request)
    }

    suspend fun getUsers(token: String): Response<ArrayList<User>> {
        return RetrofitInstance.api.getUsers(token)
    }

    suspend fun getMyUser(token: String): Response<User> {
        return RetrofitInstance.api.getMyUser(token)
    }

    suspend fun getMyTasks(token: String): Response<ArrayList<Task>> {
        return RetrofitInstance.api.getMyTasks(token)
    }

    suspend fun createTask(request: TaskRequest, token: String): Response<TaskResponse> {
        return RetrofitInstance.api.createTask(request, token)
    }

    suspend fun getDepartments(token: String): Response<ArrayList<Group>> {
        return RetrofitInstance.api.getDepartments(token)
    }

    suspend fun getDepartmentMembers(token: String, departmentId: Int): Response<ArrayList<User>> {
        return RetrofitInstance.api.getDepartmentMembers(token, departmentId)
    }

    suspend fun getActivities(token: String): Response<ArrayList<Any>> {
        return RetrofitInstance.api.getActivities(token)
    }
}