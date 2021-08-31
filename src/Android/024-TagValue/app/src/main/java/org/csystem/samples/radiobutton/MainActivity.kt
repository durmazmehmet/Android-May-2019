package org.csystem.samples.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun radioGroupCheckedChange(rg: RadioGroup, id: Int)
    {
        Toast.makeText(this, findViewById<RadioButton>(id).tag as String, Toast.LENGTH_SHORT).show()
    }

    private fun getSelectedRadio(radioGroup: RadioGroup) = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

    private fun initViews()
    {
        mainActivityRadioGroupMaritalStatus.setOnCheckedChangeListener (this::radioGroupCheckedChange)
        mainActivityRadioGroupEducation.setOnCheckedChangeListener {
            rg, id ->
                if (id == R.id.mainActivityRadioButtonOther)
                    mainActivityEditTextOtherEducation.visibility = View.VISIBLE
                else {
                    mainActivityEditTextOtherEducation.setText("")
                    mainActivityEditTextOtherEducation.visibility = View.GONE
                }
                radioGroupCheckedChange(rg, id)
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

    fun onOKButtonClicked(view: View)
    {
        var msg = "Medeni Durumu:${getSelectedRadio(mainActivityRadioGroupMaritalStatus).text}"

        msg += ", Eğitim Durumu:${getSelectedRadio(mainActivityRadioGroupEducation).text}"

        mainActivityTextViewResult.text = msg
    }
}
