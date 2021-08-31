package org.csystem.samples.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun initViews()
    {
        mainActivityToggleButtonConnect.setOnCheckedChangeListener {
            _, checked -> Toast.makeText(this, if (checked)  "Açık" else "Kapalı", Toast.LENGTH_LONG).show()
        }
    }
    private fun init()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
}
