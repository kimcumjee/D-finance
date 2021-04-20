package com.stock.d_finance.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EconomyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "메인"
    }
    val text: LiveData<String> = _text
}