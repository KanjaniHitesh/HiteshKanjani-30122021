package com.tatvasoftpractical

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("api/user")
    fun getAllUsers(@Query("page") page :Int) : Call<Users>

    @GET("api/user")
    fun getUsers(@Query("page") page :Int) : Call<Any>

    companion object{
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }


}