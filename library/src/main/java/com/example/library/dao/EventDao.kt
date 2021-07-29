package com.example.library.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.library.models.Event

@Dao
interface EventDao {
    @Query("SELECT * FROM Event")
    fun getAllEvents()

    @Insert
    fun insert(event: Event)

}