package org.csystem.samples.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.csystem.android.activity.launchActivityForResult
import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.samples.todoapp.global.INSERT_TODO_REQUEST_CODE
import org.csystem.samples.todoapp.global.TODOINFO
import org.csystem.samples.todoapp.global.UPDATE_TODO_REQUEST_CODE
import org.csystem.samples.todoapp.service.TodoInfoService
import org.csystem.util.db.service.ServiceException

class MainActivity : AppCompatActivity() {

    private fun loadTodos() // daha sonra asenkron olacak
    {
        try {
            var adapter = ArrayAdapter(
                this, android.R.layout.simple_list_item_1,
                TodoInfoService.findTodoInfoSortedByLastUpdate()
            )
            mainActivityListViewTodoList.adapter = adapter
        }
        catch (ex: ServiceException) {
            Toast.makeText(this, "Veritabanı hatası", Toast.LENGTH_LONG).show()
        }
        catch (ex: Throwable) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun insertProc(resultCode: Int)
    {
        if (resultCode != Activity.RESULT_OK) {
            Toast.makeText(this, "Ekleme İşlemi iptal edildi", Toast.LENGTH_LONG).show()
            return
        }

        loadTodos()
    }

    private fun updateProc(resultCode: Int)
    {
        if (resultCode != Activity.RESULT_OK) {
            Toast.makeText(this, "Güncelleme İşlem iptal edildi", Toast.LENGTH_LONG).show()
            return
        }

        loadTodos()
    }

    private fun initViews()
    {
        mainActivityListViewTodoList.setOnItemClickListener { _, _, pos, _ ->
            var bundle = Bundle()

            var todoInfo = mainActivityListViewTodoList.getItemAtPosition(pos) as TodoInfo

            bundle.putSerializable(TODOINFO, todoInfo)
            launchActivityForResult(this@MainActivity, UpdateTodoActivity::class.java, UPDATE_TODO_REQUEST_CODE, bundle)
        }

        loadTodos()
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        when (requestCode) {
            INSERT_TODO_REQUEST_CODE -> insertProc(resultCode)
            UPDATE_TODO_REQUEST_CODE -> updateProc(resultCode)
        }
    }

    fun onInsertButtonClicked(view: View)
    {
        launchActivityForResult(this, InsertTodoActivity::class.java, INSERT_TODO_REQUEST_CODE)
    }

    fun onSearchButtonClicked(view: View) {}

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
