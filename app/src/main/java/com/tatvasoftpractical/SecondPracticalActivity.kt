package com.tatvasoftpractical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class SecondPracticalActivity : AppCompatActivity() {

    lateinit var viewModel: UserViewModel
    var adapter : UsersAdapter? = null
    var users  = mutableListOf<Users.Datum>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_practical)

        adapter = UsersAdapter()

        setUpRecyclerView()

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel.getAllUsers(1)!!.observe(this@SecondPracticalActivity, Observer {
           if(it!=null){
               Log.d("TAG === ",it.getData().toString())
               for(i in it.getData()!!.indices){
                   Log.d("===================", it.getData()!![i]!!.firstName.toString())
                   it.getData()!![i]?.let { it1 -> users.add(it1) }
                   Log.d("TAG === ",users.toString())
                   if(i == it.getData()!!.size-1){
                       Log.d("TAG === 1",users.toString())
                       adapter?.setUsers(users)

                   }
               }
           }
        })
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}