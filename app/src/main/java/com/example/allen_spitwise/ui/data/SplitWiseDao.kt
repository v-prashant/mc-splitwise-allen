package com.example.allen_spitwise.ui.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface SplitWiseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSpitWiseData(data: AddAmountItem)
}