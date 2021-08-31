package org.csystem.util

import kotlin.math.absoluteValue
import kotlin.math.log10
import kotlin.math.pow


data class ResultInfo(val x1: Double, var x2: Double)


private val gOnes = arrayOf("", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz")
private val gTens = arrayOf("", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan")

private fun digits(value:Int, n: Int) : IntArray
{
    if (value == 0)
        return IntArray(1)

    var number = value.absoluteValue
    var count = (log10(number.toDouble()) / n).toInt() + 1
    var exp = 10.toDouble().pow(n).toInt()

    var digits = IntArray(count)

    while (number != 0) {
        digits[--count] = number % exp
        number /= exp
    }

    return digits
}



private fun numToStrMax3Digits(value: Int) : String
{
    if (value == 0)
        return "sıfır"

    var str = if (value < 0) "eksi" else ""

    var number = value.absoluteValue

    val a = number / 100
    val b = number / 10 % 10
    val c = number % 10

    if (a != 0) {
        if (a != 1)
            str += gOnes[a]
        str += "yüz"
    }

    str += gTens[b];
    str += gOnes[c]

    return str
}


fun Int.digits() = digits(this, 1)
fun Int.digitsInThrees() = digits(this, 3)

fun Int.digitsCount() : Int
{
    var value = this
    var count = 0

    do {
        ++count;
        value /= 10
    } while (value != 0)

    return count
}

fun digitsSum(a:Int) : Int
{
    var sum = 0
    var value = a

    while (value != 0) {
        sum += value % 10
        value /= 10
    }

    return Math.abs(sum)
}

fun factorial(value:Int) : Int {
    if (value < 0)
        return -1

    var result = 1

    for (i in 1..value)
        result *= i

    return result
}


fun getRoots(a: Double, b: Double, c: Double): ResultInfo
{
    val delta = b * b - 4 * a * c
    return when {
        delta > 0 -> {
            val sqrtDelta = Math.sqrt(delta)
            val x1 = (-b + sqrtDelta) /(2 * a)
            val x2 = (-b - sqrtDelta) /(2 * a)

            ResultInfo(x1, x2)
        }
        delta == 0.0 -> {
            var x = -b / (2 * a)

            ResultInfo(x, x)
        }
        else -> ResultInfo(Double.NaN, Double.NaN)
    }
}

fun isArmstrong(a: Int) : Boolean
{
    if (a < 0)
        return false

    var count = a.digitsCount()
    var temp = a

    var sum = 0

    while (temp != 0) {
        sum += pow(temp % 10, count)
        temp /= 10
    }

    return sum == a
}

fun Int.isPalindrome() = reverse(this) == this

fun Int.isPrime() : Boolean
{
    var value = this

    if (value <= 1)
        return false

    if (value % 2 == 0)
        return value == 2

    if (value % 3 == 0)
        return value == 3

    if (value % 5 == 0)
        return value == 5

    if (value % 7 == 0)
        return value == 7

    var n = 11

    while (n * n <= value) {
        if (value % n == 0)
            return false
        n += 2
    }

    return true
}

fun numToStr(value: Int) : String
{
    return numToStrMax3Digits(value)
}


fun pow(a: Int, b: Int) : Int
{
    var p = Math.abs(b)
    var result = 1

    for (i in 1..p)
        result *= a

    return result
}

fun reverse(a: Int) : Int
{
    var rev = 0
    var value = a

    while (value != 0) {
        rev = rev * 10 + value % 10
        value /= 10
    }

    return rev
}
