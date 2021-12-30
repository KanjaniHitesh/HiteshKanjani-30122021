package com.tatvasoftpractical

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_user.view.*

class UsersAdapter  : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    var userList  = mutableListOf<Users.Datum>()

    fun setUsers(users: MutableList<Users.Datum>) {
        Log.d("setUsers == ","")
        this.userList.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_user, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.personName.text = userList[position].firstName +" "+ userList[position].lastName

        holder.personEmail.text = userList[position].email

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var personName = view.personName
        var personEmail = view.personEmail
    }


}