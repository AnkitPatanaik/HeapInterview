package com.example.library

import android.app.Application
import com.example.library.models.Event
import com.example.library.repositories.EventRepository
import java.util.*

object SDK {

    private var eventRepository: EventRepository? = null

    fun logEvent(application: Application, location: String, action: String){
        if (eventRepository == null) {
            eventRepository = EventRepository(application)
        }
        val uuid = UUID.randomUUID().toString()
        val event = Event(uuid, location, action, Date().time.toString())

        eventRepository!!.addEvent(event)
    }
}