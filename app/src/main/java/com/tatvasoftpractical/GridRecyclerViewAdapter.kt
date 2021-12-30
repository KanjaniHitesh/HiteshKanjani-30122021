package com.tatvasoftpractical

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_box.view.*

class GridRecyclerViewAdapter : RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder>() {

    var boxList  = mutableListOf<BoxModel>()
    var listener: OnBoxClickListener?= null

    fun setBoxes(boxList : List<BoxModel>){
        this.boxList = boxList.toMutableList()
        notifyDataSetChanged()
    }

    fun setBoxListener(listener : OnBoxClickListener){
       this.listener = listener;
    }

    fun updateActiveBox(index :Int){
        Log.d("updateActiveBox ", index.toString())
        boxList[index-1].isActive = true
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_box, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var boxModel = boxList[position]
        Log.d("Adapter = ", position.toString() +" "+ boxModel.isActive.toString())

        if(boxModel.isActive && boxModel.isSelected){
            holder.linearLayout.setBackgroundColor(Color.BLUE)
        }else if(boxModel.isActive){
            holder.linearLayout.setBackgroundColor(Color.RED)
        }else{
            holder.linearLayout.setBackgroundColor(Color.WHITE)
        }

        holder.linearLayout.setOnClickListener {
          if(boxModel.isActive && !boxModel.isSelected){
              boxModel.isSelected = true
              notifyDataSetChanged()
              listener?.onClick(boxList)
          }
        }

    }

    override fun getItemCount(): Int {
       return boxList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var linearLayout = view.linearLayout
    }

    interface OnBoxClickListener{
        fun onClick(boxList: List<BoxModel>)
    }

}