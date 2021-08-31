package org.csystem.samples.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show()

        if (savedInstanceState == null)
            Toast.makeText(this, "newly created", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "system created", Toast.LENGTH_LONG).show()
    }

    override fun onStart()
    {
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show()
        super.onStart()
    }

    override fun onResume()
    {
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show()
        super.onResume()
    }


    override fun onPause()
    {
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show()
        super.onPause()
    }

    override fun onStop()
    {
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show()
        super.onStop()
    }

    override fun onRestart()
    {
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show()
        super.onRestart()
    }

    override fun onDestroy()
    {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }





}
