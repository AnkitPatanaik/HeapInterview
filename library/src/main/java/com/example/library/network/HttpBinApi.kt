package com.example.library.network

import com.example.library.models.Event
import retrofit2.http.Body
import retrofit2.http.POST

interface HttpBinApi {
    @POST("post")
    fun uploadEvents(@Body events: List<Event>)
}