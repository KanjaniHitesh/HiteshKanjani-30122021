package com.tatvasoftpractical

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class SecondPracticalActivity : AppCompatActivity() {

    lateinit var viewModel: UserViewModel
    var adapter : UsersAdapter? = null
    var users  = mutableListOf<Users.Data>()
    var layoutManager: LinearLayoutManager?=null
    var isLoading : Boolean = false;
    var pageNo  = 1;
    var totalPages  = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_practical)

        adapter = UsersAdapter(this)

        setUpRecyclerView()

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

       callUserApi()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager?.childCount
                val pastVisibleItem = layoutManager?.findFirstCompletelyVisibleItemPosition()
                val total = adapter?.itemCount

                if(totalPages > pageNo ){
                    if (!isLoading && totalPages!=0) {
                        if ((visibleItemCount!! + pastVisibleItem!!) >= total!!) {
                            Log.d("==============="," === ");
                            pageNo++
                            callUserApi()
                        }
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun callUserApi() {
        isLoading = true;
        viewModel.getAllUsers(1)!!.observe(this@SecondPracticalActivity, Observer {
            if (it != null) {
                isLoading = false;
                totalPages = it.getTotalPages()!!
                users.clear()
//                Log.d("TAG === ", it.getData().toString())
                for (i in it.getData()!!.indices) {
                    Log.d("===================", it.getData()!![i]!!.first_name.toString())
                    it.getData()!![i]?.let { it1 -> users.add(it1) }
                    if (i == it.getData()!!.size - 1) {
//                        Log.d("TAG === 1", users.toString())
                        adapter?.setUsers(users, pageNo)

                    }
                }
            }
        })
    }

    private fun setUpRecyclerView() {
        layoutManager = LinearLayoutManager(this);
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }
}