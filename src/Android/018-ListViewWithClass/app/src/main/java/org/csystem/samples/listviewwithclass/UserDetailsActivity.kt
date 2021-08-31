package org.csystem.samples.listviewwithclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_details.*
import org.csystem.samples.listviewwithclass.entity.UserInfo

class UserDetailsActivity : AppCompatActivity() {

    private fun initViews()
    {
        var user = intent.getSerializableExtra("USER") as UserInfo

        userDetailsActivityTextViewUsername.text = user.username
        userDetailsActivityTextViewPassword.text = user.password
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

    fun onOKButtonClicked(view: View)
    {
        finish()
    }

    fun onTextViewPasswordClicked(view: View)
    {
        Toast.makeText(this, userDetailsActivityTextViewPassword.text, Toast.LENGTH_SHORT).show()
    }
}
