package org.csystem.samples.devicesapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_device.*
import org.csystem.samples.deviceapp.service.DeviceService
import org.csystem.samples.deviceinfocommon.entity.DeviceInfo
import org.csystem.samples.devicesapp.global.DEVICE_INFO
import org.csystem.util.db.service.ServiceException

class UpdateDeviceActivity : AppCompatActivity() {
    private lateinit var mDevice: DeviceInfo

    private fun initViews()
    {
        mDevice = intent.getSerializableExtra(DEVICE_INFO) as DeviceInfo
        updateDeviceActivityTextViewName.text = mDevice.name
        updateDeviceActivityEditTextHost.setText(mDevice.host)
        updateDeviceActivityTextViewInsertDate.text = mDevice.insertDate.toString()
        updateDeviceActivityTextViewLastUpdate.text = mDevice.lastUpdate.toString()
    }

    private fun init()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_device)
        init()
    }

    fun onSaveButtonClicked(view: View)
    {
        try {
            mDevice.host = updateDeviceActivityEditTextHost.text.toString()
            DeviceService.update(mDevice)
            setResult(Activity.RESULT_OK)
            finish()
        }
        catch (ex: ServiceException) {
            Toast.makeText(this, "Veritabanı hatası", Toast.LENGTH_LONG).show()
        }
        catch (ex: Throwable) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }

    fun onDeleteButtonClicked(view: View)
    {
        try {
            mDevice.host = updateDeviceActivityEditTextHost.text.toString()
            DeviceService.deleteById(mDevice.name)
            setResult(Activity.RESULT_OK)
            finish()
        }
        catch (ex: ServiceException) {
            Toast.makeText(this, "Veritabanı hatası", Toast.LENGTH_LONG).show()
        }
        catch (ex: Throwable) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }
}
