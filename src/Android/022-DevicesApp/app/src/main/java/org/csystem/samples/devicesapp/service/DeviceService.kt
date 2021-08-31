package org.csystem.samples.devicesapp.service

import android.content.Context
import org.csystem.samples.devicesapp.entity.DeviceInfo
import org.csystem.samples.devicesapp.repository.DeviceRepository
import org.csystem.samples.devicesapp.repository.IDeviceRepository
import org.csystem.util.db.service.ServiceException


object DeviceService {
    private val mRepository: IDeviceRepository = DeviceRepository

    fun save(device: DeviceInfo): Boolean
    {
        try {
            if (DeviceRepository.existsById(device.name))
                return false

            mRepository.save(device)

            return true
        }
        catch (ex: Throwable) {
            throw ServiceException("Exception in save", ex)
        }
    }

    fun update(device: DeviceInfo): Boolean
    {
        try {
            return mRepository.update(device)
        }
        catch (ex: Throwable) {
            throw ServiceException("Exception in update", ex)
        }
    }


    fun deleteById(name: String)
    {
        try {
            mRepository.deleteById(name)
        }
        catch (ex: Throwable) {
            throw ServiceException("Exception in deleteById", ex)
        }
    }

    val devices: Iterable<DeviceInfo>
        get() {
            try {
                return mRepository.findAllSortedByLastUpdate()
            }
            catch (ex: Throwable) {
                throw ServiceException("Exception in devices property", ex)
            }
        }

}

