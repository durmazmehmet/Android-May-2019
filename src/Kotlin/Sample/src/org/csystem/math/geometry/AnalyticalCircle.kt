package org.csystem.math.geometry

class AnalyticalCircle(r: Double = 0.0, x: Int = 0, y: Int = 0) : Circle(r) {
    private var mCenter: Point

    init {
        mCenter = Point(x, y)
    }

    var x: Int
        get() = mCenter.x
        set(x) {mCenter.x = x}

    var y: Int
        get() = mCenter.y
        set(y) {mCenter.y = y}

    var center: Point
        get() = Point(mCenter.x, mCenter.y)
        set(p)
        {
            mCenter.x = p.x
            mCenter.y = p.y
        }

    constructor(x:Int, y:Int) : this(0.0, x, y)
    constructor(r:Double, p:Point) : this(r, p.x, p.y)

    fun offset(dx: Int, dy: Int = dx) //delegate method
    {
        mCenter.offset(dx, dy)
    }

    //...
}