package com.example.scb4

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CountriesAdapter(var countries: Array<String>) : RecyclerView.Adapter<CountriesHolder>() {
    var TAG = CountriesAdapter::class.java.simpleName
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesHolder {
        Log.i(TAG,"priyanshu  bought a row plank")
        var rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return  CountriesHolder(rowPlank)

    }

    override fun getItemCount(): Int {
        Log.i(TAG,"bhani  count =" + countries.size)

        return  countries.size
    }

    override fun onBindViewHolder(holder: CountriesHolder, position: Int) {
        Log.i(TAG,"archana is writing--"+ countries[position])
        holder.tvRowItem.setText(countries[position])

    }
}

class CountriesHolder(itemView: View) : ViewHolder(itemView) {
    var tvRowItem = itemView.findViewById<TextView>(R.id.tvRow)


}
