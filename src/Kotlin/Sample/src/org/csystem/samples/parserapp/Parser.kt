package org.csystem.samples.parserapp

class Parser(var source: ISource) {
    fun doParse()
    {
        var count = 0

        while (true) {
            var ch = source.nextChar

            if (ch == -1)
                break;

            if (ch.toChar().isWhitespace())
                ++count
        }

        println("Boşluk sayısı:$count")
    }
    //...
}