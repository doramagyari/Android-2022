package com.example.a3tracker_projekt.api.user

import com.example.a3tracker_projekt.api.Constants
import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.api.login.LoginResponse
import com.example.a3tracker_projekt.api.profile.ProfileRequest
import com.example.a3tracker_projekt.api.profile.ProfileResponse
import com.example.a3tracker_projekt.api.task.TaskRequest
import com.example.a3tracker_projekt.api.task.TaskResponse
import com.example.a3tracker_projekt.ui.groups.Group
import com.example.a3tracker_projekt.ui.tasks.Task
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MyUserApi {

    @POST(Constants.LOGIN)
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET(Constants.GET_USERS)
    suspend fun getUsers(@Header("token") token: String): Response<ArrayList<User>>

    @GET(Constants.GET_MY_USER)
    suspend fun getMyUser(@Header("token") token: String): Response<User>

    @POST(Constants.UPDATE_PROFILE)
    suspend fun updateProfile(@Body request: ProfileRequest, @Header("token") token: String): Response<ProfileResponse>

    @GET(Constants.GET_MY_TASKS)
    suspend fun getMyTasks(@Header("token") token: String): Response<ArrayList<Task>>

    @POST(Constants.CREATE_TASK)
    suspend fun createTask(@Body request: TaskRequest, @Header("token") token: String): Response<TaskResponse>

    @GET(Constants.GET_DEPARTMENTS)
    suspend fun getDepartments(@Header("token") token: String): Response<ArrayList<Group>>

    @GET(Constants.GET_DEPARTMENT_MEMBERS)
    suspend fun getDepartmentMembers(@Header("token") token: String, departmentId: Int): Response<ArrayList<User>>

    @GET(Constants.GET_ACTIVITIES)
    suspend fun getActivities(@Header("token") token: String): Response<ArrayList<Any>>

}