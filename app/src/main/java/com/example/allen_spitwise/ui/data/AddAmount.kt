package com.example.allen_spitwise.ui.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "split_wise_data")
data class AddAmountItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val expenseName: String?,
    val totalAmount: Int?,
    val paidBy: String?,
    val participate: ArrayList<String>?
)

