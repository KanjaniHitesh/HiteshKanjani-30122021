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

        val response1 = retrofitService.getUsers(pageNo)


        response1.enqueue(object : Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Log.d("=======================", response.body().toString())
//                usersList.postValue(response.body()!!)
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.d("====================", "err"+t.localizedMessage);
            }
        })

        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                Log.d("=======================", response.body()!!.getTotal()!!.toString())
                usersList.postValue(response.body()!!)
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.d("====================", "err"+t.localizedMessage);
            }
        })
        return  usersList
    }

}