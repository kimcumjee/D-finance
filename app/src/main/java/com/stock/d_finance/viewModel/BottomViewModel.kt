package com.stock.d_finance.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stock.d_finance.base.BaseViewModel

class BottomViewModel : BaseViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "뉴스"
    }
    val text: LiveData<String> = _text
}