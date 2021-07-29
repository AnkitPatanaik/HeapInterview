package com.example.library.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// add action, type, description etc later?
@Entity
data class Event(@PrimaryKey private val id: String, private val name: String, private val timestamp: String)
