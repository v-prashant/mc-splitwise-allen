package com.example.allen_spitwise.ui

import android.app.Application
import androidx.room.Room
import com.example.allen_spitwise.ui.data.SplitWiseDataBase

class SplitWise: Application() {

    companion object {
        private lateinit var database: SplitWiseDataBase

        fun getDataBase(): SplitWiseDataBase {
            return database
        }
    }

    override fun onCreate() {
        super.onCreate()
        initRoom()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(
            applicationContext,
            SplitWiseDataBase::class.java,
            "split_wise_db").build()
    }

}