package org.csystem.collection

class HashSetWithStatus<T> : HashSet<T>() {
    private var mFalseCount : Int = 0

    val falseCount: Int
        get() = mFalseCount

    override fun add(t: T) : Boolean
    {
        var status = super.add(t);

        if (!status)
            ++mFalseCount

        return status
    }
}