package org.csystem.samples.todoapp.service

import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.samples.todoapp.repository.ITodoInfoRepository
import org.csystem.samples.todoapp.repository.TodoInfoRepository
import org.csystem.util.db.service.ServiceException

object TodoInfoService {
    private val mTodoRepository: ITodoInfoRepository = TodoInfoRepository

    fun save(todoInfo: TodoInfo) : TodoInfo
    {
        try {
            mTodoRepository.save(todoInfo)

            return todoInfo
        }
        catch (ex: Throwable) {
            throw  ServiceException("exception in save", ex)
        }
    }

    fun findTodoInfoSortedByLastUpdate(): List<TodoInfo>
    {
        try {
            return mTodoRepository.findTodoInfosSortedByLastUpdate().toList()
        }
        catch (ex: Throwable) {
            throw  ServiceException("exception in findTodoInfosSortedByLastUpdate", ex)
        }
    }
}