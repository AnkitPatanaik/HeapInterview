package com.example.library.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.library.SDK
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

abstract class AnalyticsFragment() : Fragment() {

    private fun log(action: String) {
        GlobalScope.async(Dispatchers.IO) {
            SDK.logEvent(activity!!.application, getName(), action)
        }
    }

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("onCreate")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    @DelicateCoroutinesApi
    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }

    // name of Fragment
    abstract fun getName(): String
}