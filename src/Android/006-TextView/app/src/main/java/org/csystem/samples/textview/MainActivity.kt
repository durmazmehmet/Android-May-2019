package org.csystem.samples.textview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mCount: Int = 0

    private fun setCounter()
    {
        mainActivityTextViewCounter.text = mCount.toString()
    }

    private fun incrementProc()
    {
        ++mCount
        setCounter()
    }

    private fun decrementProc()
    {
        --mCount
        setCounter()
    }

    private fun resetProc()
    {
        mCount = 0
        setCounter()
    }

    private fun exitProc()
    {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonsClicked(view: View)
    {
        when (view.id) {
            R.id.mainActivityButtonIncrement -> incrementProc()
            R.id.mainActivityButtonDecrement -> decrementProc()
            R.id.mainActivityButtonReset -> resetProc()
        }
    }

    fun onExitButtonClicked(view: View)
    {
        exitProc()
    }
}
