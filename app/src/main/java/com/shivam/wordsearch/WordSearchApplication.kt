package com.shivam.wordsearch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WordSearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}