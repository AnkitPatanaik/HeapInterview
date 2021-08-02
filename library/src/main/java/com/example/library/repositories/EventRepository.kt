package com.example.library.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.example.library.dao.EventDao
import com.example.library.db.EventDatabase
import com.example.library.models.Event
import com.example.library.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EventRepository(application: Application) {
    var eventDao: EventDao

    init {
        eventDao = EventDatabase.getDb(application).eventDao()
    }

    suspend fun addEvent(event: Event) {
        eventDao.insert(event)
    }

    suspend fun uploadEvents(application: Application) {
        if (verifyAvailableNetwork(application)) {
            val events = eventDao.getAllEvents()

            val call = RetrofitClient.client.uploadEvents(events)
            // using retrofit enqueue for simplicity. can use any async network handling here
            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    Log.d("EventRepository", "successfully uploaded events")
                    // clear db once they're uploaded to network
                    GlobalScope.async(Dispatchers.IO) {
                        eventDao.clear()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable?) {
                    Log.e("EventRepository", t.toString())
                    Log.d("EventRepository", "failed to upload events :(")
                }
            })
        }
    }

    private fun verifyAvailableNetwork(activity: Application) : Boolean {
        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isConnected
    }
}