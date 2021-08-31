package org.csystem.samples.eventdrivenmethods

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private fun init()
    {
        //...
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun onOKButtonsClicked(view: View)
    {
        var msg = " Clicked"

        when (view.id) {
            R.id.mainActivityButtonOK1 -> msg = "OK1" + msg
            R.id.mainActivityButtonOK2 -> msg = "OK2" + msg
            R.id.mainActivityButtonOK3 -> msg = "OK3" + msg
            R.id.mainActivityButtonOK4 -> msg = "OK4" + msg
            R.id.mainActivityButtonOK5 -> msg = "OK5" + msg
        }

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
