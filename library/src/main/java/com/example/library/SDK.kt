package com.example.library

import android.content.Context
import com.example.library.db.EventDatabase
import com.example.library.models.Event
import com.example.library.modules.EventModule
import com.example.library.repositories.EventRepository
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject
import java.util.*

object SDK {
    const val SCOPE = "scope"

    private val eventRepository: EventRepository by inject()

    fun initDependencies(context: Context) {
        val scope = KTP.openScope(SCOPE)

        val eventModule = EventModule(EventDatabase.getDb(context))

        scope.installModules(eventModule)
    }

    fun logEvent(location: String, action: String){
        val uuid = UUID.randomUUID().toString()
        val event = Event(uuid, location, action, Date().time.toString())
        eventRepository.addEvent(event)
    }
}