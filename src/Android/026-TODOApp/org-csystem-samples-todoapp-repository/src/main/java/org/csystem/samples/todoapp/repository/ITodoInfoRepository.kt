package org.csystem.samples.todoapp.repository

import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.util.db.repository.ICrudRepository

interface ITodoInfoRepository : ICrudRepository<TodoInfo, String> {
    fun findTodoInfosSortedByLastUpdate(): Iterable<TodoInfo>
}