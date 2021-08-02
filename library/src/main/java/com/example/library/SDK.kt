package com.example.library

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import com.example.library.models.Event
import com.example.library.repositories.EventRepository
import java.util.*

object SDK {

    private var eventRepository: EventRepository? = null

    suspend fun logEvent(application: Application, location: String, action: String){
        if (eventRepository == null) {
            eventRepository = EventRepository(application)
        }
        val uuid = UUID.randomUUID().toString()
        val event = Event(uuid, location, action, Date().time.toString())

        eventRepository!!.addEvent(event)
    }

    suspend fun uploadEvents(application: Application, lifecycleOwner: LifecycleOwner) {
        if (eventRepository == null) {
            eventRepository = EventRepository(application)
        }
        eventRepository!!.uploadEvents(application, lifecycleOwner)
    }
}