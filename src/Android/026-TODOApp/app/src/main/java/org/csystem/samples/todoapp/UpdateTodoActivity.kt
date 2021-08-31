package org.csystem.samples.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_insert_todo.*
import kotlinx.android.synthetic.main.activity_update_todo.*
import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.samples.todoapp.global.TODOINFO

class UpdateTodoActivity : AppCompatActivity() {
    private lateinit var mTodoInfo: TodoInfo
    private fun initPrioritySpinner()
    {
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Priority.values())

        updateTodoActivtySpinnerPriority.adapter = adapter
    }

    private fun initTodoData()
    {
        mTodoInfo = intent.getSerializableExtra(TODOINFO) as TodoInfo
        updateTodoActivtySpinnerPriority.setSelection(mTodoInfo.priority.ordinal)
        updateTodoActivtyEditTextTitle.setText(mTodoInfo.title)
        updateTodoActivtyEditTextDescription.setText(mTodoInfo.description)
        updateTodoActivtySwitchCompleted.isChecked = mTodoInfo.completed
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
        setContentView(R.layout.activity_update_todo)
        init()
    }

    fun onSaveButtonClicked(view: View) {}
    fun onDeleteButtonClicked(view: View) {}
}
