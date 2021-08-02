package com.example.heapinterview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.SDK
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    suspend fun uploadEvents(application: Application) {
        viewModelScope.launch {
            SDK.uploadEvents(application)
        }
    }
}