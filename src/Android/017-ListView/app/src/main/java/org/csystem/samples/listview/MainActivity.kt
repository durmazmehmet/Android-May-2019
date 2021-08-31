package org.csystem.samples.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var mAdapter: ArrayAdapter<String>
    private val mTextList = ArrayList<String>()

    private fun initListView()
    {
        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mTextList)
        mainActivityListViewTexts.adapter = mAdapter
        mainActivityListViewTexts.setOnItemClickListener(this)
    }

    private fun initViews()
    {
        initListView()
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

    override fun onItemClick(p0: AdapterView<*>?, view: View?, pos: Int, id: Long)
    {
        //Diziden al
        var msg = mTextList[pos]

        Toast.makeText(this, "From Array:${msg}", Toast.LENGTH_LONG).show()

        msg = mAdapter.getItem(pos)!!

        Toast.makeText(this, "From Adapter:${msg}", Toast.LENGTH_LONG).show()

        msg = mainActivityListViewTexts.getItemAtPosition(pos) as String

        Toast.makeText(this, "From ListView:${msg}", Toast.LENGTH_LONG).show()
    }

    fun onAddWithAdapterButtonClicked(view: View)
    {
        mAdapter.add(mainActivityEditTextText.text.toString())
        mAdapter.notifyDataSetChanged()
    }

    fun onAddWithArrayListButtonClicked(view: View)
    {
        mTextList.add(mainActivityEditTextText.text.toString())
        mAdapter.notifyDataSetChanged()
    }
}
