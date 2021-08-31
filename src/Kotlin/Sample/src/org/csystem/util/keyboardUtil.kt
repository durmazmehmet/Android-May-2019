package org.csystem.util

fun readDouble() = readDouble("")

fun readDouble(msg: String) = readDouble(msg, "")

fun readDouble(msg: String, errMsg: String) : Double
{
    var value: Double

    while (true) {
        try {
            print(msg)
            value = readLine()!!.toDouble()
            return value
        }
        catch (ex: NumberFormatException) {
            print(errMsg)
        }
    }
}

fun readDoubleLine(msg: String) = readDouble(msg, "")
fun readDoubleLine(msg: String, errMsg: String) = readDouble(msg + "\n", errMsg + "\n")

fun readInt() = readInt("")

fun readInt(msg: String) = readInt(msg, "")

fun readInt(msg: String, errMsg: String) : Int
{
    var value: Int

    while (true) {
        try {
            print(msg)
            value = readLine()!!.toInt()
            return value
        }
        catch (ex: NumberFormatException) {
            print(errMsg)
        }
    }
}

fun readIntLine(msg: String) = readIntLine(msg, "")
fun readIntLine(msg: String, errMsg: String) = readInt(msg + "\n", errMsg + "\n")

fun readLong() = readLong("")

fun readLong(msg: String) : Long
{
    print(msg)
    return readLine()!!.toLong()
}

fun readLongLine(msg: String) = readLong(msg + "\n")

fun readString() = readString("")
fun readString(msg: String) : String
{
    print(msg)
    return readLine()!!
}

fun readStringLine(msg: String) = readString(msg + "\n")





