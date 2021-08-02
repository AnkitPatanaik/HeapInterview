package com.example.library.modules

import com.example.library.dao.EventDao
import com.example.library.db.EventDatabase
import com.example.library.repositories.EventRepository
import toothpick.config.Module

class EventModule(db: EventDatabase) : Module() {

    init {
        bind(EventDao::class.java).toInstance(db.eventDao())
        bind(EventRepository::class.java).toInstance(EventRepository())
    }
}