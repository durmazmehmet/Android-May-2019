package org.csystem.samples.todoapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_insert_todo.*
import kotlinx.android.synthetic.main.activity_update_todo.*
import org.csystem.samples.todoapp.databinding.ActivityUpdateTodoBinding
import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.samples.todoapp.global.TODOINFO
import org.csystem.samples.todoapp.service.TodoInfoService

class UpdateTodoActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityUpdateTodoBinding
    private fun initPrioritySpinner()
    {
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Priority.values())

        updateTodoActivtySpinnerPriority.adapter = adapter
    }

    private fun initTodoData()
    {
        mBinding.todoInfo = intent.getSerializableExtra(TODOINFO) as TodoInfo
    }

    private fun initViews()
    {
        initPrioritySpinner()
        initTodoData()
    }

    private fun init()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_todo)
        init()
    }

    fun onSaveButtonClicked(view: View)
    {
        TodoInfoService.update(mBinding.todoInfo!!)

        setResult(Activity.RESULT_OK)
        finish()
    }
    fun onDeleteButtonClicked(view: View)
    {}
}
