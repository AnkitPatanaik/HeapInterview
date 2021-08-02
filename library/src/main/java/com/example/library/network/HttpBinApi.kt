package com.example.library.network

import com.example.library.models.Event
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface HttpBinApi {
    @POST("post")
    fun uploadEvents(@Body events: List<Event>) : Call<ResponseBody>
}