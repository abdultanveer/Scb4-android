package com.example.scb4.ui.dashboard

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
     lateinit var timer:CountDownTimer

     private  val _seconds = MutableLiveData<Int>()
    //val seconds = LiveData<Int>()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }


    fun seconds():LiveData<Int>{
        return _seconds
    }
    fun startTime(){
        timer = object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                var timeLeft = millisUntilFinished/1000
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }

        }.start()
    }

    val text: LiveData<String> = _text

    var number = 0

    fun addNumber(){
        number++
    }
}