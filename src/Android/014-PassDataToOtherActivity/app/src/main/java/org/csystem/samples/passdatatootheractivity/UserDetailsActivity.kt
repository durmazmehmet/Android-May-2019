package org.csystem.samples.passdatatootheractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    private fun initViews()
    {
        userDetailsActivityTextViewUsername.text = intent.getStringExtra(USERNAME)
        userDetailsActivityEditTextFullname.setText(intent.getStringExtra(FULLNAME))
        userDetailsActivityTextViewEmail.text = intent.getStringExtra(EMAIL)
        userDetailsActivityTextViewGender.text =
            if (intent.getBooleanExtra(GENDER, true)) "BAYAN" else "BAY"
    }
    private fun init()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        init()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
