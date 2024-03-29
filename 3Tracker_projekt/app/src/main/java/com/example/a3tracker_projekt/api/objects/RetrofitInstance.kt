package com.example.a3tracker_projekt.api.objects

import com.example.a3tracker_projekt.api.objects.Constants.BASE_URL
import com.example.a3tracker_projekt.api.interfaces.MyUserApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val api: MyUserApi by lazy{
        retrofit.create(MyUserApi::class.java)
    }

}