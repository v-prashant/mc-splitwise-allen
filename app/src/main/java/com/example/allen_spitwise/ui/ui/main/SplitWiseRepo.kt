package com.example.allen_spitwise.ui.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.allen_spitwise.ui.SplitWise
import com.example.allen_spitwise.ui.data.AddAmountItem

class SplitWiseRepo {

    suspend fun addSplitWiseData(data: AddAmountItem?) {
        if (data != null) {
            SplitWise.getDataBase().splitWiseDao().addSpitWiseData(data)
        }
    }

    fun getAllExpenses(): LiveData<List<AddAmountItem>> {
        return SplitWise.getDataBase().splitWiseDao().getAllExpenses()
    }

}