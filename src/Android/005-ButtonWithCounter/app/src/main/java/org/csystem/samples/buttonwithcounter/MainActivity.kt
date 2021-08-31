package org.csystem.samples.buttonwithcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mCount = 0

    private fun setCount()
    {
        mainActivityButtonCounter.text = (mCount++).toString()
    }

    private fun initViews()
    {
        setCount()
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

    fun onCounterButtonClicked(view: View)
    {
        setCount()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
