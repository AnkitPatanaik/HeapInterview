package com.example.library.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.library.dao.EventDao
import com.example.library.db.EventDatabase
import com.example.library.models.Event
import com.example.library.network.RetrofitClient


class EventRepository(private val application: Application) {
    var eventDao: EventDao

    init {
        eventDao = EventDatabase.getDb(application).eventDao()
    }

    suspend fun addEvent(event: Event) {
        eventDao.insert(event)
    }

    suspend fun uploadEvents(application: Application, lifecycleOwner: LifecycleOwner) {
        if (verifyAvailableNetwork(application)) {
            val events = eventDao.getAllEvents()

//            events.observe(lifecycleOwner, Observer {
//                // upload events to Network
//                RetrofitClient.client.uploadEvents(it)
//            })
            RetrofitClient.client.uploadEvents(events)
            eventDao.clear()
        }
    }

    private fun verifyAvailableNetwork(activity: Application) : Boolean {
        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isConnected
    }
}