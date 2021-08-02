package com.example.library.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.library.SDK

abstract class AnalyticsFragment() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SDK.logEvent(activity!!.application, getName(), "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()

        SDK.logEvent(activity!!.application, getName(), "onDestroy")
    }

    // name of Fragment
    abstract fun getName(): String
}