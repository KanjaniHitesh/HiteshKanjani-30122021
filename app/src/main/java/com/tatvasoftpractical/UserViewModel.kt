package com.tatvasoftpractical

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val retrofitService = RetrofitService.getInstance()

    fun getAllUsers(pageNo:Int) : LiveData<Users>?{
        Log.d("TAG TAG = ", pageNo.toString())
       return UserRepository(retrofitService).getAllUsers(pageNo)!!
    }


}