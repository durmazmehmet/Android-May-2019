package org.csystem.util

fun displayDateTR(day: Int, mon: Int, year: Int)
{
    val dayOfWeek = getDayOfWeek(day, mon, year)

    print("$day/$mon/$year ")

    when (dayOfWeek) {
        0 -> print("Pazar ")
        1 -> print("Pazartesi ")
        2 -> print("Salı ")
        3 -> print("Çarşamba ")
        4 -> print("Perşembe ")
        5 -> print("Cuma ")
        6 -> print("Cumartesi ")
    }
    println("yılın ${getDayOfYear(day, mon, year)}. günüdür")
}

fun getDayOfWeek(day: Int, mon: Int, year: Int) : Int
{
    var dayOfYear = getDayOfYear(day, mon, year)

    if (dayOfYear < 0)
        return -1

    for (y in 1900 until year)
        dayOfYear += when {
            isLeapYear(y) -> 366
            else -> 365
        }

    return dayOfYear % 7
}

fun getDayOfYear(day: Int, mon: Int, year: Int) : Int
{
    if (!isValidDate(day, mon, year))
        return -1

    var dayOfYear = day

    for (m in 1 until mon) {
        dayOfYear += when (m) {
            1, 3, 5, 7, 8, 10 -> 31
            4, 6, 9, 11 -> 30
            else -> if (isLeapYear(year)) 29 else 28
        }
    }

    return dayOfYear
}

fun isValidDate(day: Int, mon: Int, year: Int) : Boolean
{
    if (day < 1 || day > 31 || mon < 1 || mon > 12)
        return false

    var days = when (mon) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        else -> if (isLeapYear(year)) 29 else 28
    }

    return day <= days
}

fun isLeapYear(year: Int) = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
