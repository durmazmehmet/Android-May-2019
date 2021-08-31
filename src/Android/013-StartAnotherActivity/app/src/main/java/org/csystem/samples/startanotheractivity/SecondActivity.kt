package org.csystem.samples.startanotheractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
