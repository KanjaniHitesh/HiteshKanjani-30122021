package com.tatvasoftpractical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var valueNumber : Double? = 0.0
    var totalBoxes : Int? = 0
    var adapter : GridRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = GridRecyclerViewAdapter()

        submit.setOnClickListener {
            if(number.text.isNotEmpty()){
                try {
                    valueNumber = Math.sqrt(number.text.toString().toDouble())

                    if (valueNumber!!.toInt() < valueNumber!! && valueNumber != 0.0){
                        Toast.makeText(this, "Invalid value", Toast.LENGTH_LONG).show()
                        Log.d("MainActivity == num", valueNumber.toString())
                        valueNumber = 0.0
                        totalBoxes = 0
                    }else{
                        totalBoxes = number.text.toString().toInt()
                        Toast.makeText(this, "Valid value", Toast.LENGTH_LONG).show()
                        setUpRecyclerView()
                        setUpBoxArray(totalBoxes!!)
                    }

                }catch (e:Exception){
                    Log.d("MainActivity == e", e.toString())
                }

            }

        }
    }

    private fun setUpBoxArray(totalBoxes: Int){
        var boxList = mutableListOf<BoxModel>()

        for (i in 1..totalBoxes){
            boxList.add(BoxModel(i, isActive = false, isSelected = false))
            if(i == totalBoxes){
                adapter?.setBoxes(boxList.toMutableList())
//                star
            }
        }
    }

    private fun setUpRecyclerView() {
        Log.d("TAG == ", valueNumber!!.toInt().toString())
        recyclerView.layoutManager = GridLayoutManager(this, valueNumber!!.toInt())
        recyclerView.adapter = adapter

    }
}