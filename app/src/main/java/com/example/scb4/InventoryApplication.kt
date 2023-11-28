package com.example.scb4

import android.app.Application
import com.example.scb4.data.ItemRoomDatabase

class InventoryApplication: Application() {

    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }

}