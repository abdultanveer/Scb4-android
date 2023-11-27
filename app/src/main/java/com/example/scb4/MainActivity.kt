package com.example.scb4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayHello(view: View) {
        var view = findViewById<ConstraintLayout>(R.id.constraint_lyt)
        Snackbar.make(this,view,"welcome to android at scb",Snackbar.LENGTH_SHORT).show()
    }
}