package com.example.library.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.library.SDK
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

abstract class AnalyticsFragment() : Fragment() {

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.async(Dispatchers.IO) {
            SDK.logEvent(activity!!.application, getName(), "onCreate")
        }
    }

    @DelicateCoroutinesApi
    override fun onDestroy() {
        super.onDestroy()

        GlobalScope.async(Dispatchers.IO) {
            SDK.logEvent(activity!!.application, getName(), "onDestroy")
        }
    }

    // name of Fragment
    abstract fun getName(): String
}