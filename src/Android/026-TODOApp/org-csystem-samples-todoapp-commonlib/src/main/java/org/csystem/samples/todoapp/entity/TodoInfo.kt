package org.csystem.samples.todoapp.entity

import org.csystem.samples.todoapp.Priority
import org.csystem.util.datetime.DateTime
import java.io.Serializable

data class TodoInfo(var id: Int = 0, var title: String = "", var description: String = "",
                    var priority: Priority = Priority.NORMAL,
                    val createDate: DateTime = DateTime.now(), var lastUpdate: DateTime = createDate,
                    var completed: Boolean = false) : Serializable {

    override fun toString() = "$title"
}