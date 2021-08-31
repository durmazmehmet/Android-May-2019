package org.csystem.samples.eventdrivenmethods

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(v: View?)
        {
            Toast.makeText(this@MainActivity, "OK5 Clicked", Toast.LENGTH_LONG).show()
        }
    }

    private fun initViews()
    {
        mainActivityButtonOK2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?)
            {
                Toast.makeText(this@MainActivity, "OK2 Clicked", Toast.LENGTH_LONG).show()
            }
        })

        mainActivityButtonOK3.setOnClickListener {
            Toast.makeText(this@MainActivity, "OK3 Clicked", Toast.LENGTH_LONG).show()
        }

        mainActivityButtonOK4.setOnClickListener(this)

        mainActivityButtonOK5.setOnClickListener(ButtonClickListener())
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

    override fun onClick(v: View?)
    {
        Toast.makeText(this, "OK4 Clicked", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy()
    {
        Toast.makeText(this, "MainActivity Destroyed", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    fun onOK1ButtonClicked(v: View)
    {
        Toast.makeText(this, "OK1 Clicked", Toast.LENGTH_LONG).show()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }


}
