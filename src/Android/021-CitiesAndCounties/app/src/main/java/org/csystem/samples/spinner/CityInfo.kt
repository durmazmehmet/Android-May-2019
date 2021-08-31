package org.csystem.samples.spinner

data class CityInfo(var plate:Int, var name: String) {
    private val mCounties: ArrayList<String> = ArrayList()

    val counties: Array<String>
        get() {
            var array = Array(mCounties.count()) {""}

            return mCounties.toArray(array)
        }

    fun addCounty(name: String) : CityInfo
    {
        mCounties.add(name)

        return this
    }


    override fun toString() = name
}