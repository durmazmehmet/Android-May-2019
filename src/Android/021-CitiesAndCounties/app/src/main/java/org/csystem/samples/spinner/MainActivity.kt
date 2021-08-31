package org.csystem.samples.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var mCitiesAdapter: ArrayAdapter<CityInfo>

    private fun loadCities() : ArrayList<CityInfo> // Şehirlerin elde edildiği metot
    {
        var cities = ArrayList<CityInfo>()

        cities.add(CityInfo(34, "istanbul").addCounty("şişli").addCounty("fatih").addCounty("beşiktaş"))
        cities.add(CityInfo(67, "zonguldak").addCounty("kdz. ereğli").addCounty("devrek"))
        cities.add(CityInfo(35, "izmir").addCounty("karşıyaka").addCounty("göztepe").addCounty("buca"))

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
        var cityInfo = mCitiesAdapter.getItem(pos)!!

        mainActivitySpinnerCounties.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cityInfo.counties)
    }

    fun onDisplayButtonClicked(view: View)
    {
        var cityInfo = mainActivitySpinnerCities.selectedItem as CityInfo

        Toast.makeText(this, "selected item: ${cityInfo.plate}", Toast.LENGTH_LONG).show()


    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
