package org.csystem.samples.parserapp

open class KeyboardSource() : ISource {
    private val mStringSource: StringSource

    init {
        print("Bir yazı giriniz:")
        mStringSource = StringSource(readLine()!!)

    }

    override val nextChar: Int
                get() = mStringSource.nextChar
}