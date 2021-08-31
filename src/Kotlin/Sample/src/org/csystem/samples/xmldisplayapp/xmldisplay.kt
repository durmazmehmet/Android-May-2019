package org.csystem.samples.xmldisplayapp

import org.csystem.util.readString

private typealias NameList = ArrayList<String>
private typealias NamesList =  ArrayList<NameList>

private val gNames = NamesList()

private fun readNames()
{
    println("Yazıları girmeye başlayınız:")

    while (true) {
        var namesStr = readString()
        if (namesStr == "exit")
            break

        var namesArray = namesStr.split(' ', '\t')
        gNames.add(NameList(namesArray));
    }
}

private fun display()
{
    println("<Names>")
    for (line in gNames) {
        println("\t<Line>")
        for (name in line)
            println("\t\t<Name>$name</Name>")
        println("\t</Line>")
    }
    println("</Names>")
}

fun runDisplayXMLApp()
{
    readNames()
    display()
}