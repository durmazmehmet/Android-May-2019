package org.csystem.samples.todoapp.application

import android.widget.Toast
import org.csystem.android.application.App

class TodoApp : App() {
    override fun onCreate()
    {
        Toast.makeText(this.baseContext, "Application started", Toast.LENGTH_LONG).show()
        super.onCreate()
    }
}