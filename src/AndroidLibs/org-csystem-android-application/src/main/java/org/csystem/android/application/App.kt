package org.csystem.android.application

import android.app.Application

open class App : Application() {
    companion object {
        private lateinit var mInstance: App
        val instance: App get() = mInstance
    }

    override fun onCreate()
    {
        mInstance = this
        super.onCreate()
    }
}