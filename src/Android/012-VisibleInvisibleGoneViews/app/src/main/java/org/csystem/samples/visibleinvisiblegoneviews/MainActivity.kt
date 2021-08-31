package org.csystem.samples.visibleinvisiblegoneviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun clearViews()
    {
        var count = mainActivityLinearLayoutViews.childCount

        for (i in 0 until count) {
            var view = mainActivityLinearLayoutViews.getChildAt(i)

            if (view is Switch)
                view.isChecked = false

            if (view is EditText)
                view.setText("")
        }
    }

    private fun makeGone(enable: Boolean = true)
    {
        var count = mainActivityLinearLayoutViews.childCount

        for (i in 0 until count)
            mainActivityLinearLayoutViews.getChildAt(i).visibility = if (enable) View.GONE else View.VISIBLE
    }

    private fun makeInvisible(enable: Boolean = true)
    {
        var count = mainActivityLinearLayoutViews.childCount

        for (i in 0 until count)
            mainActivityLinearLayoutViews.getChildAt(i).visibility = if (enable) View.INVISIBLE else View.VISIBLE
    }

    private fun initViews()
    {
        mainActivityToggleButtonGoneVisible.setOnCheckedChangeListener {
                _, checked -> makeGone(!checked)
        }

        mainActivityToggleButtonInvisibleVisible.setOnCheckedChangeListener {
                _, checked -> makeInvisible(!checked)
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

    fun onClearButtonClicked(view: View)
    {

    }

}
