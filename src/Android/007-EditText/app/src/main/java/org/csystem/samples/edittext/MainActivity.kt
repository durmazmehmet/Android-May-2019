package org.csystem.samples.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun String.getCharIfSatisfies(ch: Char) = if (this == "") "" else ch.toString()

    private fun validate(firstName: String, surname: String) : Boolean
    {
        var errMsg = ""

        if (firstName.isEmpty())
            errMsg += "Ad kısmı boş geçilemez"

        if (surname.isEmpty())
            errMsg += "${errMsg.getCharIfSatisfies('\n')}Soyad kısmı boş geçilemez"

        var status = errMsg == ""

        if (!status)
            Toast.makeText(this, errMsg, Toast.LENGTH_LONG).show()

        return status
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSaveButtonClicked(view: View)
    {
        var firstName = mainActivityEditTextFirstName.text.toString().trim()
        var surname = mainActivityEditTextSurname.text.toString().trim()

        if (!validate(firstName, surname))
            return

        var secondName = mainActivityEditTextSecondName.text.toString()

        var fullname = "${firstName.toLowerCase().capitalize()} ${if (secondName.isBlank()) "" else " " + secondName.toLowerCase().capitalize() + " "}${surname.toUpperCase()}"

        mainActivityTextViewFullName.text = fullname
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }

    fun onFullNameTextViewClicked(view: View)
    {
        var text = mainActivityTextViewFullName.text

        if (!text.isEmpty())
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
