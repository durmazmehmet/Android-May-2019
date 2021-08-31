package org.csystem.samples

import kotlin.random.Random

fun getLotteryColumn() : IntArray
{
    var intSet = mutableSetOf<Int>()

    while (intSet.count() != 6)
        intSet.add(Random.nextInt(1, 50))

    return intSet.sortedBy { it }.toIntArray()
}
