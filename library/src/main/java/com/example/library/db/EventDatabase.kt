package com.example.library.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.library.dao.EventDao
import com.example.library.models.Event

@Database(entities = [Event::class], version = 1)
abstract class EventDatabase : RoomDatabase() {
    abstract fun eventDao() : EventDao
}