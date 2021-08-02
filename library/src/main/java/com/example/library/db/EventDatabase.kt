package com.example.library.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.library.dao.EventDao
import com.example.library.models.Event

@Database(entities = [Event::class], version = 1)
abstract class EventDatabase : RoomDatabase() {
    abstract fun eventDao() : EventDao

    companion object {
        @Volatile
        private var instance: EventDatabase? = null

        fun getDb(context: Context) : EventDatabase {
            val i = instance
            if (i != null) {
                return i
            }

            synchronized(EventDatabase::class.java) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EventDatabase::class.java,
                        "Event_DB"
                    )
                        .setJournalMode(JournalMode.WRITE_AHEAD_LOGGING)
                        .build()
                }
                return instance!!
            }
        }
    }
}