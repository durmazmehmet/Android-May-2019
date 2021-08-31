package org.csystem.samples.todoapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_insert_todo.*
import org.csystem.samples.todoapp.databinding.ActivityInsertTodoBinding
import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.samples.todoapp.service.TodoInfoService
import org.csystem.util.db.service.ServiceException

class InsertTodoActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityInsertTodoBinding
    private fun initPrioritySpinner()
    {
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Priority.values())

        insertTodoActivtySpinnerPriority.adapter = adapter
    }

    private fun initViews()
    {
        initPrioritySpinner()

        //...
    }

    private fun init()
    {
        initViews()

    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_insert_todo)
        mBinding.todoInfo = TodoInfo()
        init()
    }

    fun onSaveButtonClicked(view: View)
    {
        try {
            TodoInfoService.save(mBinding.todoInfo!!)
            Toast.makeText(this, mBinding.todoInfo.toString(), Toast.LENGTH_LONG).show()
            setResult(Activity.RESULT_OK)
            finish()
        }
        catch (ex: ServiceException) {
            Toast.makeText(this, "Veritabanı hatası", Toast.LENGTH_SHORT).show()
        }
        catch (ex:Throwable) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        }
    }
    fun onExitButtonClicked(view: View) {}
    fun onCancelButtonClicked(view: View) {}
}
