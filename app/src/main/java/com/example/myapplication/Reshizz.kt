/*package com.example.myapplication

open class Reshizz() {




}

fun Reshizz.reshi(s : String) {
    var list1 = arrayListOf("")
    //var znaki = charArrayOf('x', '+', '-', '/')
    var result = 0.0
    var n = 0
    var x = String()
    var y: Double
    if (s[0] == '-') list1[0] = "0"


    repeat(s.length-1){
        when (s[n]) {
            'x' -> {list1.add(x)
                x = ""
                list1.add(s[n].toString())
            }
            '+' -> {list1.add(x)
                x = ""
                list1.add(s[n].toString())
            }
            '-' -> {list1.add(x)
                x = ""
                list1.add(s[n].toString())
            }
            '=' -> {list1.add(x)
                x = ""
                list1.add(s[n].toString())
            }

            else -> x += s[n].toString()
        }
        n += 1
    }

    var n2 = 0
    list1.forEach {
        when (list1[n2]) {
            "x" -> {

                y = list1[n2 - 1].toDouble() * list1[n2 + 1].toDouble()
                list1[n2 - 1] = y.toString()
                list1.remove(list1[n2])
                list1.remove(list1[n2 + 1])
            }

            "/" -> {
                y = list1[n2 - 1].toDouble() / list1[n2 + 1].toDouble()
                list1[n2 - 1] = y.toString()
                list1.remove(list1[n2])
                list1.remove(list1[n2 + 1])
            }

            else -> n2 += 1

        }
    }
    result = list1[0].toDouble()
    var f = 1

    list1.forEach {
        when (list1[f]) {
            "+" -> {
                result = result.plus(list1[f + 1].toDouble())
                f += 2
            }

            "-" -> {
                result +=  result.minus(list1[f + 1].toDouble())
                f += 2
            }
        }
    }


    return result.toString()
}
*/


