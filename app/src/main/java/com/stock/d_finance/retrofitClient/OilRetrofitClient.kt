package com.stock.d_finance.retrofitClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OilRetrofitClient {
    private val BASE_URL = "https://api.oilpriceapi.com/v1/prices/latest"
    fun getRetrofitClient() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
//    fun getWeatherService(retrofit: Retrofit) : WeatherService {
//        return retrofit.create(WeatherService::class.java)
//    }
}