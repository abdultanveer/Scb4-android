package com.example.scb4.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.scb4.data.Item
import com.example.scb4.data.ItemDao
import kotlinx.coroutines.launch

class HomeViewModel(private val itemDao: ItemDao) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

     fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
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