package com.example.library.repositories

import com.example.library.dao.EventDao
import com.example.library.models.Event
import toothpick.ktp.delegate.inject

class EventRepository {
    private val eventDao: EventDao by inject()

    fun addEvent(event: Event) {
        eventDao.insert(event)
    }

    fun uploadEvents() {
        val events = eventDao.getAllEvents()

        // upload events to Network

        eventDao.clear()
    }
}