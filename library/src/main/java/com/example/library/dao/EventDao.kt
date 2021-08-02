package com.example.library.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.library.models.Event

@Dao
interface EventDao {
    @Query("SELECT * FROM Event")
    suspend fun getAllEvents() : List<Event>

    @Query("DELETE FROM EVENT")
    suspend fun clear()

    @Insert
    suspend fun insert(event: Event)

}