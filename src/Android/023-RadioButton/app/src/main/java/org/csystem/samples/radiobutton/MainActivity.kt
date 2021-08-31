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
        Toast.makeText(this, findViewById<RadioButton>(id).text, Toast.LENGTH_SHORT).show()
    }

    private fun getSelectedRadio(radioGroup: RadioGroup) = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

    private fun getSelectedRadioWithLoop(radioGroup: RadioGroup) : RadioButton?
    {
        val childCount = radioGroup.childCount

        for (i in 0 until childCount) {
            val view = radioGroup.getChildAt(i)

            if (view !is RadioButton)
                continue

            if (view.isChecked)
                return view
        }

        return null
    }

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

        msg += ", Eğitim Durumu:${getSelectedRadioWithLoop(mainActivityRadioGroupEducation)?.text}"

        mainActivityTextViewResult.text = msg
    }
}
