package com.example.library.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// add action, type, description etc later?
@Entity
data class Event(@PrimaryKey val id: String,
                 val location: String,
                 val action: String,
                 val timestamp: String)
