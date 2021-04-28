package com.stock.d_finance.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stock.d_finance.Service.OilService
import com.stock.d_finance.base.BaseViewModel
import com.stock.d_finance.retrofitClient.OilRetrofitClient
import kotlinx.coroutines.*
import retrofit2.Retrofit

class MainViewModel : BaseViewModel() {
    lateinit var retrofit: Retrofit
    lateinit var oilService: OilService
    private var total = MutableLiveData<String>()
    val totalData : LiveData<String>
    get() = total
    val API_KEY = "92dbeb03ce707e228a26d5538289cc53"
    fun oil(){

        retrofit = OilRetrofitClient.getRetrofitClient()
        oilService = OilRetrofitClient.getOilService(retrofit)
        CoroutineScope(Dispatchers.IO).launch {
            val response = oilService.getOilPrice("Bearer $API_KEY")
            if(response.isSuccessful){
                response.body()?.let {
                    withContext(Dispatchers.Main){
                        Log.d("기름값","기름값 : ${it.data.formatted}")
                        total.value = it.data.formatted
                    }
                }
                Log.d("유가", "유가 : ${response.body()}")
            }else{
                Log.d("실패","실패 : ${response.errorBody()}")
            }
        }

    }
}