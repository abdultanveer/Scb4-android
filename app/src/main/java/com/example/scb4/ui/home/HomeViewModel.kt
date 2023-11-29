package com.example.scb4.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.scb4.data.Item
import com.example.scb4.data.ItemDao
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(private val itemDao: ItemDao) : ViewModel() {
     var mitem = MutableLiveData<Item>()
    lateinit var item: Item


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

     fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }

    fun findItem(itemId: Int) {

        viewModelScope.async {
             var item = itemDao.getItem(itemId)
           // Log.i(TAG,"item received is--"+item.collect())
        }

    }

    fun retrieveItem(id: Int): LiveData<Item> {
        return itemDao.getItem(id).asLiveData()

    }
}

class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")    }
}