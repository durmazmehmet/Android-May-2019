package org.csystem.math

private fun plus(re1: Double, im1: Double, re2: Double, im2: Double) = Complex(re1 + re2, im1 + im2)
private fun minus(re1: Double, im1: Double, re2: Double, im2: Double) = plus(re1, im1, -re2, -im2)
infix operator fun Double.plus(c: Complex) = Complex(this + c.re, c.im)
infix operator fun Double.minus(c: Complex) = this.plus(-c)
infix operator fun Int.plus(c: Complex) = this.toDouble().plus(c)
infix operator fun Int.minus(c: Complex) = this.plus(-c)
infix operator fun Long.plus(c: Complex) = this.toDouble().plus(c)
infix operator fun Long.minus(c: Complex) = this.plus(-c)
infix operator fun Short.plus(c: Complex) = this.toDouble().plus(c)
infix operator fun Short.minus(c: Complex) = this.plus(-c)

data class Complex(var re: Double = 0.0, var im: Double = 0.0) {
    val norm: Double
        get() = Math.sqrt(re * re + im * im)

    constructor(a:Int, b: Int) : this(a.toDouble(), b.toDouble())

    operator fun component3() = norm

    infix operator fun plus(z: Complex) = plus(re, im, z.re, z.im)
    infix operator fun plus(value: Double) = plus(re, im, value, 0.0)
    infix operator fun plus(value: Int) = plus(re, im, value.toDouble(), 0.0)
    operator fun unaryMinus() = Complex(-re, -im)
    operator fun unaryPlus() = this.copy()

    operator fun inc() = 1.0 + this // Dikkat: Yeni Complex nesnesi yaratılıp onun referansı döndürülmeli ve artırma ona yapılmalı
    operator fun dec() = -1.0 + this// Dikkat: Yeni Complex nesnesi yaratılıp onun referansı döndürülmeli ve azaltma ona yapılmalı
    operator fun invoke() = println(this)
    operator fun invoke(re: Double, im: Double)
    {
        this.re = re
        this.im = im
    }
    operator fun invoke(re: Int, im: Int) = invoke(re.toDouble(), im.toDouble())
    override fun toString() = "$re + i * $im"
}


