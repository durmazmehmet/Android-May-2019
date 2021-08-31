package org.csystem.samples.devicesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert_device.*
import org.csystem.samples.devicesapp.entity.DeviceInfo
import org.csystem.samples.devicesapp.service.DeviceService
import org.csystem.util.db.service.ServiceException

class InsertDeviceActivity : AppCompatActivity() {

    private fun getDevice() : DeviceInfo
    {
        var name = insertDeviceActivityEditTextName.text.toString().trim()
        var host = insertDeviceActivityEditTextHost.text.toString().trim()
        var ports = insertDeviceActivityEditTextPorts.text.toString().split(",")
        var device = DeviceInfo(name, host, insertDeviceActivitySwitchActive.isChecked)

        ports.map { it.toInt() }.forEach {device.addPort(it)}

        return device
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_device)
    }

    fun onSaveButtonClicked(view: View)
    {
        try {
            if (DeviceService.save(getDevice()))
                onExitButtonClicked(view);
            else
                Toast.makeText(this, "Bu cihaz daha önce eklenmiştir", Toast.LENGTH_LONG).show()
        }
        catch (ex: ServiceException) {
            Toast.makeText(this, "Veritabanında beklenmedik bir durum oluştu", Toast.LENGTH_LONG).show()
        }
        catch (ex: NumberFormatException) {
            Toast.makeText(this, "Port numaraları hatalı girildi", Toast.LENGTH_LONG).show()
        }
        catch (ex: Throwable) {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }

    fun onClearButtonClicked(view: View)
    {
        //...
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
