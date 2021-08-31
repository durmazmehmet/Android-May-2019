package org.csystem.samples.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

typealias CityInfo = Pair<Int, String>

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var mCitiesAdapter: ArrayAdapter<CityInfo>

    private fun loadCities() : ArrayList<CityInfo> // Şehirlerin elde edildiği metot
    {
        var cities = ArrayList<CityInfo>()

        cities.add(Pair(34, "istanbul"))
        cities.add(Pair(67, "zonguldak"))
        cities.add(Pair(6, "ankara"))
        cities.add(Pair(35, "izmir"))

        cities.sortBy { it.first }

        return cities
    }

    private fun initViews()
    {
        mCitiesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, loadCities())
        mainActivitySpinnerCities.adapter = mCitiesAdapter
        mainActivitySpinnerCities.onItemSelectedListener = this
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

    override fun onNothingSelected(p0: AdapterView<*>?)
    {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long)
    {
        var cityInfo = mCitiesAdapter.getItem(pos)

        Toast.makeText(this, "City:${cityInfo?.second}", Toast.LENGTH_LONG).show()
    }

    fun onDisplayButtonClicked(view: View)
    {
        var cityInfo = mainActivitySpinnerCities.selectedItem as CityInfo

        Toast.makeText(this, "selected item: ${cityInfo.second}", Toast.LENGTH_LONG).show()

        cityInfo = mCitiesAdapter.getItem(mainActivitySpinnerCities.selectedItemPosition)!!

        Toast.makeText(this, "selected index: ${cityInfo.second}", Toast.LENGTH_LONG).show()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
