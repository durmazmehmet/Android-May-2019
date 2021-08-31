package org.csystem.samples.parserapp

open class CharArraySource (str: String) : ISource {
    private val mChars: CharArray = CharArray(str.length)

    init {
        for (i in mChars.indices)
            mChars[i] = str[i]
    }

    private var m_index: Int = 0
    override val nextChar : Int
            get() = if (m_index == mChars.count()) -1 else mChars[m_index++].toInt()
}