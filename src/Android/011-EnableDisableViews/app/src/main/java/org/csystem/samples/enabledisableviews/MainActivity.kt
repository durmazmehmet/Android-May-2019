package org.csystem.samples.enabledisableviews

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
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

    private fun enableViews(enable: Boolean = true)
    {
        var count = mainActivityLinearLayoutViews.childCount

        for (i in 0 until count)
            mainActivityLinearLayoutViews.getChildAt(i).isEnabled = enable
    }

    private fun initViews()
    {
        enableViews(mainActivityToggleButtonEnable.isChecked)
        mainActivityToggleButtonEnable.setOnCheckedChangeListener {
            _, checked -> enableViews(checked)
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
        if (mainActivityToggleButtonEnable.isChecked)
            clearViews()
        //...
    }


}
