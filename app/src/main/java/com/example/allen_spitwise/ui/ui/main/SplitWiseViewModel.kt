package com.example.allen_spitwise.ui.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allen_spitwise.ui.data.AddAmountItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplitWiseViewModel: ViewModel() {

    private val repo = SplitWiseRepo()
    fun addSplitWiseData(addData: AddAmountItem?) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addSplitWiseData(addData)
        }
    }

}