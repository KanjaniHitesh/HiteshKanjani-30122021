package com.tatvasoftpractical
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.single_user.view.*


class UsersAdapter(context:Context)  : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    var context = context;
    var userList  = mutableListOf<Users.Data>()

    fun setUsers(users: MutableList<Users.Data>, pageNo: Int) {
        Log.d("setUsers == ", "")
        if (pageNo == 1){
            this.userList.clear()
        }
        this.userList.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_user, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)

        Glide.with(context).load(userList[position].avatar).apply(options).into(holder.imageView)

        holder.personName.text = userList[position].first_name +" "+ userList[position].last_name

        holder.personEmail.text = userList[position].email

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var personName = view.personName
        var imageView = view.imageView
        var personEmail = view.personEmail
    }


}