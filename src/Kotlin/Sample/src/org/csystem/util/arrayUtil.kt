package org.csystem.util

import kotlin.random.Random

fun display(a: IntArray, n: Int = 1)
{
    var fmt = "%%0%dd ".format(n)

    for (value in a)
        print(fmt.format(value))

    println()
}

fun display(a: DoubleArray)
{
    for (value in a)
        print("$value ")

    println()
}

fun randomIntArray(n: Int, min: Int, max: Int) : IntArray
{
    var result = IntArray(n)

    for (i in result.indices)
        result[i] = Random.nextInt(min, max)

    return result
}

fun randomDoubleArray(n: Int, min: Double, max: Double) : DoubleArray
{
    var result = DoubleArray(n)

    for (i in result.indices)
        result[i] = Random.nextDouble(min, max)

    return result
}