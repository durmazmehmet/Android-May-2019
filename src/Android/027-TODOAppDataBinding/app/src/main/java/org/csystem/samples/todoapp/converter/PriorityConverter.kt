package org.csystem.samples.todoapp.converter

import androidx.databinding.InverseMethod
import org.csystem.samples.todoapp.Priority

object PriorityConverter {
    @InverseMethod("toPriority")
    @JvmStatic
    fun toInt(priority: Priority) = priority.ordinal

    @JvmStatic
    fun toPriority(ordinal: Int) = Priority.values()[ordinal]
}