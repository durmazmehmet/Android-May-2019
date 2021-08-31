package org.csystem.math.geometry

data class Point(var x: Int = 0, var y: Int = 0) {
    fun distance(p: Point) = distance(p.x, p.y)
    fun distance(a: Int = 0, b: Int = 0) = Math.sqrt(Math.pow(x.toDouble() - a, 2.0) + Math.pow(y.toDouble() - b, 2.0))

    fun offset(dx: Int, dy: Int = dx)
    {
        x += dx;
        y += dy;
    }

    override fun toString() = "($x, $y)"
}
