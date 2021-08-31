package org.csystem.samples.devicesapp.entity

import org.csystem.util.datetime.DateTime
import java.io.Serializable

data class DeviceInfo(var name: String, var host: String = "", var isActive: Boolean = false,
                      val insertDate: DateTime = DateTime.now(),
                      var lastUpdate: DateTime = insertDate) : Serializable { // İleride daha detaylanacak
    private var mPorts = ArrayList<Int>()

    val ports: Array<Int>
            get() {
                var p = Array<Int>(mPorts.count()) {0}

                return mPorts.toArray(p)
            }

    fun addPort(port: Int)
    {
        //...
        mPorts.add(port)
    }

    override fun equals(other: Any?): Boolean
    {
        if (other == null || other !is DeviceInfo)
            return false

        return this.name == other.name
    }

    override fun toString() = "$name:[$host]:[${lastUpdate.toString()}]${if (isActive) "Aktif" else "Aktif değil"}"
}