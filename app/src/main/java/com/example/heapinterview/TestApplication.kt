package com.example.heapinterview

import android.app.Application
import com.example.library.SDK

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SDK.initDependencies(this)
    }
}