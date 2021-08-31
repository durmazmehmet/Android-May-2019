package org.csystem.samples.devicesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onInsertDeviceButtonClicked(view: View)
    {
        var intent = Intent(this, InsertDeviceActivity::class.java)

        startActivity(intent)
    }

    fun onListDevicesButtonClicked(view: View)
    {
        var intent = Intent(this, ListDevicesActivity::class.java)

        startActivity(intent)
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }


}
