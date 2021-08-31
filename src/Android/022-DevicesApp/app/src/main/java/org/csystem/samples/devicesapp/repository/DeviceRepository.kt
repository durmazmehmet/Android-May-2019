package org.csystem.samples.devicesapp.repository

import android.content.Context
import org.csystem.samples.devicesapp.entity.DeviceInfo
import org.csystem.util.Optional
import org.csystem.util.datetime.DateTime

object DeviceRepository : IDeviceRepository {
    private val mDevices = ArrayList<DeviceInfo>()

    override fun <S : DeviceInfo> save(s: S): S
    {
        mDevices.add(s)

        return s
    }

    override fun deleteById(name: String)
    {
        val optional = findById(name)

        if (optional.isPresent)
            mDevices.remove(optional.get())
    }

    override fun deleteAll(p0: MutableIterable<DeviceInfo>)
    {
        throw UnsupportedOperationException()
    }

    override fun deleteAll()
    {
        throw UnsupportedOperationException()
    }

    override fun <S : DeviceInfo?> saveAll(p0: MutableIterable<S>?): MutableIterable<S>
    {
        throw UnsupportedOperationException()
    }

    override fun count(): Long
    {
        throw UnsupportedOperationException()
    }

    override fun existsById(name: String): Boolean
    {
        return mDevices.contains(DeviceInfo(name))
    }

    override fun findAll(): Iterable<DeviceInfo>
    {
        throw UnsupportedOperationException()
    }

    override fun findById(name: String): Optional<DeviceInfo>
    {
        if (!existsById(name))
            return Optional.empty()

        return Optional.of(mDevices[mDevices.indexOf(DeviceInfo(name))])
    }

    override fun findAllById(p0: MutableIterable<String>?): MutableIterable<DeviceInfo>
    {
        throw UnsupportedOperationException()
    }

    override fun findAllSortedByLastUpdate(): Iterable<DeviceInfo>
    {
        return mDevices.sortedByDescending { it.lastUpdate }

    }

    override fun delete(p0: DeviceInfo?)
    {
        throw UnsupportedOperationException()
    }

    override fun update(deviceInfo: DeviceInfo) : Boolean
    {
        val optional = findById(deviceInfo.name)

        if (optional.isEmpty)
            return false

        val device = optional.get();

        device.host = deviceInfo.host
        device.lastUpdate = DateTime.now()

        return true
    }
}