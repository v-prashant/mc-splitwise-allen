package com.example.allen_spitwise.ui.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.allen_spitwise.ui.utills.Converters

@Database(entities = [AddAmountItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SplitWiseDataBase: RoomDatabase() {
    abstract fun splitWiseDao(): SplitWiseDao
}