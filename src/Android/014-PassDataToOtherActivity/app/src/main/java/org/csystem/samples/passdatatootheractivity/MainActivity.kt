package org.csystem.samples.passdatatootheractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onOKButtonClicked(view: View)
    {
        try {
            //...
            val intent = Intent(this, UserDetailsActivity::class.java)

            intent.putExtra(FULLNAME, mainActivityEditTextName.text.toString()
                    + " " + mainActivityEditTextSurname.text.toString())

            intent.putExtra(USERNAME, mainActivityEditTextUsername.text.toString())
            intent.putExtra(EMAIL, mainActivityEditTextEmail.text.toString())
            intent.putExtra(GENDER, mainActivityCheckBoxGender.isChecked)

            startActivity(intent)
        }
        catch (ex: Throwable) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }


    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
