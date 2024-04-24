package com.example.allen_spitwise.ui.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SplitWiseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSpitWiseData(data: AddAmountItem)

    @Query("SELECT * FROM split_wise_data")
    fun getAllExpenses(): LiveData<List<AddAmountItem>>
}