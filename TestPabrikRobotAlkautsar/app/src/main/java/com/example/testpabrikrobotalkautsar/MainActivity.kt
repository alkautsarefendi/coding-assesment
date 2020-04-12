package com.example.testpabrikrobotalkautsar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val arrayList: MutableList<String> = ArrayList()
    var result = ""
    var reload = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGenerate.setOnClickListener {
            if(etTotal.text.toString().isNotEmpty()){
                if(reload){
                    recyclerView.adapter= null
                }
                generateRandom(etTotal.text.toString().toInt())
                reload = true
            }else{
                Toast.makeText(this,"Silakan isi jumlah  nama aygn akan di buat",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun generateRandom(total : Int){
        for (i in 0 until total) {
            val chars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
            val number = "1234567890".toCharArray()
            val sb1 = StringBuilder()
            val sb2 = StringBuilder()
            val random1 = Random()
            for (i in 0..1) {
                val c1 = chars1[random1.nextInt(chars1.size)]
                sb1.append(c1)
            }
            for (i in 0..2) {
                val c1 = number[random1.nextInt(number.size)]
                sb2.append(c1)
            }
            val random_string = sb1.toString()
            val random_number = sb2.toString()

            result = random_string + random_number

            Log.d("result",result)
            arrayList.add(result)
            setData()
        }

    }

    private fun setData(){

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyRecyclerViewAdapter(this, arrayList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
