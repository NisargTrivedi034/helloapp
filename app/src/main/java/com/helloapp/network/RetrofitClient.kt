package com.helloapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://api.dilhindustani.co/"


    val retrofitClient : Retrofit.Builder by lazy {
        val levelType : HttpLoggingInterceptor.Level
        levelType = HttpLoggingInterceptor.Level.BODY

        val logging= HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)

        Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient.build()).addConverterFactory(GsonConverterFactory.create())

    }
    val apiInterface:ApiInterface by lazy{
        retrofitClient.build().create(ApiInterface::class.java)
    }
}