package com.tatvasoftpractical

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository constructor(private val retrofitService: RetrofitService) {

    val usersList = MutableLiveData<Users>()

    fun getAllUsers(pageNo:Int) : MutableLiveData<Users> {
        Log.d("getAllUsers","");
        val response = retrofitService.getAllUsers(pageNo)

        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                usersList.postValue(response.body()!!)
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.d("====================", "err"+t.localizedMessage);
            }
        })
        return  usersList
    }

}