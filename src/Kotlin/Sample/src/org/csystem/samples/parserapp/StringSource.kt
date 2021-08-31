package org.csystem.samples.parserapp

open class StringSource (var str: String = "") : ISource {
    private var mIndex: Int = 0
    override val nextChar: Int
        get() = if (mIndex == str.length) -1 else str[mIndex++].toInt()
}