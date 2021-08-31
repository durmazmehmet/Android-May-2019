package org.csystem.samples.devicesapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_devices.*
import org.csystem.samples.devicesapp.entity.DeviceInfo
import org.csystem.samples.devicesapp.global.DEVICE_INFO
import org.csystem.samples.devicesapp.global.DEVICE_UPDATE_ACTIVITY_REQUEST_CODE
import org.csystem.samples.devicesapp.service.DeviceService

class ListDevicesActivity : AppCompatActivity(), AdapterView.OnItemClickListener{
    private lateinit var mDevicesAdapter: ArrayAdapter<DeviceInfo>

    private fun loadDevices()
    {
        val devicesList: List<DeviceInfo> = DeviceService.devices.toList()

        if (devicesList.isEmpty()) {
            finish()
            Toast.makeText(this, "Henüz listeye cihaz eklenmemiş", Toast.LENGTH_LONG).show()
            return
        }

        mDevicesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, devicesList)
        listDevicesActivityLitViewDevices.adapter = mDevicesAdapter
    }

    private fun initViews()
    {
        listDevicesActivityLitViewDevices.setOnItemClickListener(this)
    }

    private fun initData()
    {
        loadDevices()
    }

    private fun init()
    {
        initViews()
        initData()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_devices)
        init()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if (requestCode == DEVICE_UPDATE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK)
            loadDevices()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long)
    {
        val intent = Intent(this, UpdateDeviceActivity::class.java)

        intent.putExtra(DEVICE_INFO, mDevicesAdapter.getItem(pos))

        startActivityForResult(intent, DEVICE_UPDATE_ACTIVITY_REQUEST_CODE)
    }
}
