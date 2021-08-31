package org.csystem.samples.listviewwithclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.csystem.samples.listviewwithclass.entity.UserInfo

class MainActivity : AppCompatActivity() {
    private lateinit var mUsersAdapter: ArrayAdapter<UserInfo>

    private fun getUserInfo(user: UserInfo) : Boolean
    {
        var username = mainActivityEditTextUsername.text.toString().trim()
        var password = mainActivityEditTextPassword.text.toString()
        var passwordAgain = mainActivityEditTextConfirmPassword.text.toString()

        //...

        if (password != passwordAgain)
            return false

        user.username = username
        user.password = password

        return true
    }

    private fun initViews()
    {
        mUsersAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ArrayList<UserInfo>())
        mainActivityListViewUsers.adapter = mUsersAdapter
        mainActivityListViewUsers.setOnItemClickListener { _, _, pos, _ ->
            var user = mUsersAdapter.getItem(pos)

            var intent = Intent(this, UserDetailsActivity::class.java)

            intent.putExtra("USER", user)

            startActivity(intent)
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

    fun onRegisterButtonClicked(view: View)
    {
        try {
            var user = UserInfo()

            if (!getUserInfo(user)) {
                Toast.makeText(this, "password must be confirmed", Toast.LENGTH_LONG).show()
                return
            }

            mUsersAdapter.add(user)
            mUsersAdapter.notifyDataSetChanged()
        }
        catch (ex: Throwable) {
            Toast.makeText(this, "Beklenmedik bir durum oluştu", Toast.LENGTH_LONG).show()
        }
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
