package org.csystem.samples.todoapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_insert_todo.*
import kotlinx.android.synthetic.main.activity_update_todo.*
import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.samples.todoapp.global.TODOINFO
import org.csystem.samples.todoapp.service.TodoInfoService
import org.csystem.util.db.service.ServiceException

class InsertTodoActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_insert_todo)
        init()
    }

    fun onSaveButtonClicked(view: View)
    {
        try {
            val title = insertTodoActivtyEditTextTitle.text.toString()
            val description = insertTodoActivtyEditTextDescription.text.toString()
            val priority = insertTodoActivtySpinnerPriority.selectedItem as Priority

            var todoInfo = TodoInfo(title = title, description = description, priority = priority)

            TodoInfoService.save(todoInfo)
            Toast.makeText(this, todoInfo.toString(), Toast.LENGTH_LONG).show()
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
