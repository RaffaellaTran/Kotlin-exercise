package com.example.rafaellat.kotlinexercise

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class LogTimberTree : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}