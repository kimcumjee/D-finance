package com.stock.d_finance.viewModel

import android.util.Log
import com.stock.ant.base.BaseViewModel
import com.stock.d_finance.BuildConfig
import com.stock.d_finance.Service.OilService
import com.stock.d_finance.retrofitClient.OilRetrofitClient
import kotlinx.coroutines.*
import retrofit2.Retrofit

class MainViewModel : BaseViewModel() {
    lateinit var retrofit: Retrofit
    lateinit var oilService: OilService
    val API_KEY = "92dbeb03ce707e228a26d5538289cc53"
    fun oil(){
        retrofit = OilRetrofitClient.getRetrofitClient()
        oilService = OilRetrofitClient.getOilService(retrofit)
        CoroutineScope(Dispatchers.IO).launch {
            val response = oilService.getOilPrice("${API_KEY}")
            if(response.isSuccessful){
                Log.d("유가", "유가 : ${response.body()}")
            }else{
                Log.d("실패","실패 : ${response.code()}")
            }
        }

    }
}