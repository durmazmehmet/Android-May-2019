package org.csystem.samples.todoapp

enum class Priority(val text: String) {
    VERY_URGENT("Çok acil"), URGENT("Acil"),
    NORMAL("Normal"), UNCERTAIN("Belirsiz");

    override fun toString() = text
}