/*----------------------------------------------------------------------------------------------------------------------
    const val değişkenler değeri derleme zamanında hesaplanan değişkenlerdir.
    const val değişkenlere sabit ifadesi atanmalıdır. Aksi durumda error oluşur.
    const val değişkenler yerel olarak bildirilemez. const val değişkenler
    sınıfların veri elemanları olamazlar. object'in const val veri elemanı olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

const val PI = 3.14

fun main()
{
    const val E = 2.171 //error
}

class Sample {
    const val E = 2.71 //error
}

object Mample {
    const val E = 2.71
}
