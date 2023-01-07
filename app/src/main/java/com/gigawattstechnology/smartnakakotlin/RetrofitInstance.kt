package com.gigawattstechnology.smartnakakotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var retrofit: Retrofit?=null
    val baseUrl="https://data.mongodb-api.com/app/data-tyhxg/endpoint/data/v1/"
    fun getRETROFIT():Retrofit?{
        if(retrofit==null){
            retrofit=Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build()
        }
        return retrofit
    }
}