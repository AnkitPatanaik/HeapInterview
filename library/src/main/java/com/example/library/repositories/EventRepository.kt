package com.example.library.repositories

import android.app.Application
import com.example.library.dao.EventDao
import com.example.library.db.EventDatabase
import com.example.library.models.Event

class EventRepository(application: Application) {
    var eventDao: EventDao

    init {
        eventDao = EventDatabase.getDb(application).eventDao()
    }

    fun addEvent(event: Event) {
        eventDao.insert(event)
    }

    fun uploadEvents() {
        val events = eventDao.getAllEvents()

        // upload events to Network

        eventDao.clear()
    }
}