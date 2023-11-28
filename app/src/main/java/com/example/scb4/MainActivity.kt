package com.example.scb4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var countries = arrayOf("india","australia","uk","usa","india","australia","uk","usa")

 var TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflating the activity_main.xml
        Log.i(TAG,"oncreate")
        recyclerView = findViewById(R.id.recyclerView)
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"start")
        var adapter = CountriesAdapter(countries)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG,"pause-- save game state")

    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG,"resume  -- restore the game state")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"stop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"destroy -- release all the resources")

    }
    fun sayHello(view: View) {
        add(10,20)

        var view = findViewById<ConstraintLayout>(R.id.constraint_lyt)
        Snackbar.make(this,view,"welcome to android at scb",Snackbar.LENGTH_SHORT).show()
        //Intent homeIntent = new Intent();
        var homeIntent : Intent = Intent(this,HomeActivity::class.java)
        homeIntent.putExtra("name","abdul")
        homeIntent.putExtra("subject","android")
        startActivity(homeIntent)

    }

    private fun add(i: Int, i1: Int) {

        var d = 20;
        var f = i+ d
    }
}