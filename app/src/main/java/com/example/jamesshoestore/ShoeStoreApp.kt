package com.example.jamesshoestore

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class ShoeStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}