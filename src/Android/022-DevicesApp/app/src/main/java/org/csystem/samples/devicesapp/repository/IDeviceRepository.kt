package org.csystem.samples.devicesapp.repository

import org.csystem.samples.devicesapp.entity.DeviceInfo
import org.csystem.util.db.repository.ICrudRepository

interface IDeviceRepository : ICrudRepository<DeviceInfo, String> {
    fun update(deviceInfo: DeviceInfo) : Boolean
    fun findAllSortedByLastUpdate(): Iterable<DeviceInfo>
}