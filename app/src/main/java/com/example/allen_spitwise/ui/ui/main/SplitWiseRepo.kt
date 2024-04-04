package com.example.allen_spitwise.ui.ui.main

import com.example.allen_spitwise.ui.SplitWise
import com.example.allen_spitwise.ui.data.AddAmountItem

class SplitWiseRepo {

    suspend fun addSplitWiseData(data: AddAmountItem?) {
        if (data != null) {
            SplitWise.getDataBase().splitWiseDao().addSpitWiseData(data)
        }
    }

}