package org.csystem.samples.checkboxandswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private fun initViews()
    {
        mainActivityCheckBoxAccept.setOnCheckedChangeListener {
            _, checked ->
            Toast.makeText(this, if (checked) "Kabul Ediyorum" else "Kabul Etmiyorum", Toast.LENGTH_LONG).show()
        }

        mainActivitySwitchSupports.setOnCheckedChangeListener(this)
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

    override fun onCheckedChanged(p0: CompoundButton?, checked: Boolean)
    {
        Toast.makeText(this, if (checked) "Destekliyorum" else "Desteklemiyorum", Toast.LENGTH_LONG).show()
    }

    fun onOKButtonClicked(view: View)
    {
        var msg = if (mainActivityCheckBoxAccept.isChecked) "Kabul ediyor" else "Kabul etmiyor"

        mainActivityTextViewAcceptResult.text = msg

        msg = if (mainActivitySwitchSupports.isChecked) "Destekliyor" else "Desteklemiyor"

        mainActivityTextViewSupports.text = msg
    }
}
