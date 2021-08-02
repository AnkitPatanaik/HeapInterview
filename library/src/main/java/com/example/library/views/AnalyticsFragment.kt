package com.example.library.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.library.SDK
import com.example.library.repositories.EventRepository
import toothpick.ktp.delegate.inject

abstract class AnalyticsFragment : Fragment() {
    private val eventRepository: EventRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SDK.logEvent(getName(), "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()

        SDK.logEvent(getName(), "onDestroy")
    }

    // name of Fragment
    abstract fun getName(): String
}