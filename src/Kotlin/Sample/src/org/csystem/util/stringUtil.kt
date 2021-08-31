package org.csystem.util

import kotlin.random.Random

private fun isPangram(s: String, alphabet:String) : Boolean
{
    for (ch in alphabet)
        if (!s.contains(ch, ignoreCase = true))
            return false

    return true
}


fun capitalize(s: String) : String
{
    if (s.isBlank())
        return s

    return s[0].toUpperCase() + s.substring(1).toLowerCase()
}

fun generateRandomPassword(n:Int) : String
{
    if (n <= 0)
        return ""

    var passwd = ""
    var delims = "_?:-"
    var trChars = "çÇğĞİışŞöÖ"

    for (i in 1..n) {
        passwd += when (Random.nextInt(1, 6)) {
            1 -> Random.nextInt('a'.toInt(), 'z'.toInt() + 1).toChar()
            2 -> Random.nextInt('A'.toInt(), 'Z'.toInt() + 1).toChar()
            3 -> Random.nextInt('0'.toInt(), '9'.toInt() + 1).toChar()
            4 -> trChars[Random.nextInt(0, trChars.length)]
            else -> delims[Random.nextInt(0, delims.length)]
        }
    }

    return passwd
}

fun getStringCount(s1: String, s2: String, ignoreCase: Boolean = false) : Int
{
    var count = 0
    var index = -1

    while (true) {
        index = s1.indexOf(s2, index + 1, ignoreCase)

        if (index == -1)
            break

        ++count
    }

    return count
}

fun isPangramTR(s: String) = isPangram(s, "abcçdefgğhıijklmnoöprsştuüvyz")
fun isPangramEN(s: String) =  isPangram(s, "abcdefghijklmnopqrstuwxvyz")

fun String.split(delim: String, stringSplitOptions: StringSplitOptions = StringSplitOptions.NONE) : List<String>
{
    var escapes = "[]"
    var regex = "["

    delim.forEach {
        if (escapes.contains(it))
            regex += "\\"

        regex += it.toString()
    }

    regex += "]" + (if (stringSplitOptions == StringSplitOptions.REMOVE_EMPTY_ENTRIES) "+" else "")

    return split(Regex(regex))
}
