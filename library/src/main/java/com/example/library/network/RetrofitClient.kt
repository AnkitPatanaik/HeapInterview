package com.example.library.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    const val BASE_URL = " http://httpbin.org/"
    private var okHttpClient: OkHttpClient? = null

    val client : HttpBinApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkhttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create Retrofit client
        return@lazy retrofit.create(HttpBinApi::class.java)
    }

    fun getOkhttpClient() : OkHttpClient{
        okHttpClient?.let {
            return it // if okHttpClient already exists, return non-nullable version
        }
        //add interceptors here if needed
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        return builder.build()
    }
}