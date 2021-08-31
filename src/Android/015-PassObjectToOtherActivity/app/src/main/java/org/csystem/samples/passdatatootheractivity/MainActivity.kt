package org.csystem.samples.passdatatootheractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun getUserInfo() : UserInfo
    {
        var fullname = "${mainActivityEditTextName.text.toString()} ${mainActivityEditTextSurname.text.toString().capitalize()}"
        var username = mainActivityEditTextUsername.text.toString()
        var email = mainActivityEditTextEmail.text.toString()
        var isFemale = mainActivityCheckBoxGender.isChecked

        //...

        return UserInfo(fullname, username, email, isFemale)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onOKButtonClicked(view: View)
    {
        try {
            val intent = Intent(this, UserDetailsActivity::class.java)

            intent.putExtra(USERINFO, getUserInfo())

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
