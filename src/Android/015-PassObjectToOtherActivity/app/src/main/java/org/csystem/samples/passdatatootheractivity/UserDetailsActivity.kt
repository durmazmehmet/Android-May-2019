package org.csystem.samples.passdatatootheractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_details.*
import java.io.Serializable

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var mUserInfo: UserInfo

    private fun initViews()
    {
        mUserInfo = intent.getSerializableExtra(USERINFO) as UserInfo

        userDetailsActivityTextViewUsername.text = mUserInfo.username
        userDetailsActivityEditTextFullname.setText(mUserInfo.fullname)
        userDetailsActivityTextViewEmail.text = mUserInfo.email
        userDetailsActivityTextViewGender.text = if (mUserInfo.isFemale) "BAYAN" else "BAY"

        Toast.makeText(this, mUserInfo.toString(), Toast.LENGTH_LONG).show()
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
