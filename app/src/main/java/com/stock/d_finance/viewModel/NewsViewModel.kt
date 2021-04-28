package com.stock.d_finance.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stock.d_finance.Service.NewService
import com.stock.d_finance.retrofitClient.NewsRetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class NewsViewModel : ViewModel() {

    lateinit var retrofit: Retrofit
    lateinit var newsService: NewService
    private var total = MutableLiveData<String>()
    val totalData : LiveData<String>
        get() = total
    private val API_KEY = "8c0be841f23945798630caa8ca0a8841"
    fun news(){

        retrofit = NewsRetrofitClient.getRetrofitClient()
        newsService = NewsRetrofitClient.getNewsService(retrofit)
        CoroutineScope(Dispatchers.IO).launch {
            val response = newsService.getNewsData("kr","business",API_KEY)
            if(response.isSuccessful){
                response.body()?.let {
                    withContext(Dispatchers.Main){

                    }
                }
                Log.d("유가", "유가 : ${response.body()}")
            }else{
                Log.d("실패","실패 : ${response.errorBody()}")
            }
        }

    }
}