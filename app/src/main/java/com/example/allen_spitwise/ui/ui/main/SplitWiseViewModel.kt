package com.example.allen_spitwise.ui.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allen_spitwise.ui.data.AddAmountItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class SplitWiseViewModel: ViewModel() {

    private val repo = SplitWiseRepo()

    fun addSplitWiseData(addData: AddAmountItem?) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addSplitWiseData(addData)
        }
    }

    fun getAllExpenses(): LiveData<List<AddAmountItem>> {
        return repo.getAllExpenses()
    }

    fun filterData(data: List<AddAmountItem>): HashMap<String, Int> {
        val map = HashMap<String, Int>()
        data.forEach { item ->
            val count = item.participate!!.size + 1
            map[item.paidBy!!.lowercase(Locale.ROOT)] = (map[item.paidBy.lowercase(Locale.ROOT)] ?: 0) + item.totalAmount!!/count
            item.participate.forEach {
                map[it.lowercase(Locale.ROOT)] = (map[item.paidBy.lowercase(Locale.ROOT)] ?: 0) + item.totalAmount /count
            }
        }
        return map
    }

}