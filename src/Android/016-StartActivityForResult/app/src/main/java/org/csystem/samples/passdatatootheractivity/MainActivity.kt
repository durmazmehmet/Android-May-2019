package org.csystem.samples.passdatatootheractivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.UnknownServiceException

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if (requestCode == USERDETAILS_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val userInfo = data?.getSerializableExtra(USERINFO) as UserInfo
                var fullNameData = userInfo.fullname.split(' ')

                mainActivityEditTextName.setText(fullNameData[0])
                mainActivityEditTextSurname.setText(fullNameData[1])
            }
            else
                Toast.makeText(this, "Did not update any data", Toast.LENGTH_LONG).show()
        }
    }

    fun onOKButtonClicked(view: View)
    {
        try {
            val intent = Intent(this, UserDetailsActivity::class.java)

            intent.putExtra(USERINFO, getUserInfo())

            startActivityForResult(intent, USERDETAILS_REQUEST_CODE)
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
