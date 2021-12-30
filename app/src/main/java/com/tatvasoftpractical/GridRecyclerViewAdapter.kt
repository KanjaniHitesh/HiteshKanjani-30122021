package com.tatvasoftpractical

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_box.view.*

class GridRecyclerViewAdapter : RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder>() {

    var boxList  = mutableListOf<BoxModel>()

    fun setBoxes(boxList : List<BoxModel>){
        this.boxList = boxList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_box, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var boxModel = boxList[position]

    }

    override fun getItemCount(): Int {
       return boxList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var linearLayout = view.linearLayout
    }

}