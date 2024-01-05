package com.example.myapplication

//import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
//import android.text.TextUtils.substring

//import android.view.LayoutInflater
//import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.floor


class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivityMainBinding


    var showResult: String = ""
    var lastChar = showResult.length-1

    var resultHistory = 0.0
    var history = "=$resultHistory"
    // var znaki = charArrayOf('x', '+', '-', '/') е понял как использовать


    fun reshi(s : String): String {
        var list1: ArrayList<String> = ArrayList()
        var list2: ArrayList<String> = ArrayList()
        var result = 0.0
        var x = String()
        var y: Double
        var z: Double = 0.0
        val len = s.length - 1
        var s = s
        if (s == "" || s == "/" || s == "+" || s == "*" || s == "-" ) return ""
        when (s[len]) {
            '/' -> s = s.substring(0, len)
            '-' -> s = s.substring(0, len)
            '+' -> s = s.substring(0, len)
            '.' -> s = s.substring(0, len)
            '*' -> s = s.substring(0, len)
        }
        if (s[0] == '-') s = "0" + s // "0$s" разница?
        s.forEach {
            when (it) {
                '*' -> {
                    if (x != "") list1.add(x)
                    x = ""
                    list1.add(it.toString())
                }
                '+' -> {
                    if (x != "") list1.add(x)
                    x = ""
                    list1.add(it.toString())
                }
                '-' -> {
                    if (x != "") list1.add(x)
                    x = ""
                    list1.add(it.toString())
                }
                '/' -> {
                    if (x != "") list1.add(x)
                    x = ""
                    list1.add(it.toString())
                }
                else -> x += it
            }
        }
        list1.add(x)
        if (list1.contains("*") || list1.contains("/")) {
            var len3 = list1.size - 2
            if (list1[1] == "+" || list1[1] == "-") list2.add(list1[0])
            for (n3 in 1..len3 step 2) {
                when (list1[n3]) {
                    "*" -> {
                        z = if (list2.isEmpty()) list1[n3 - 1].toDouble() else list2[list2.lastIndex].toDouble()
                        y = z * list1[n3 + 1].toDouble()
                        if (list2.isEmpty()) list2.add(y.toString()) else list2[list2.lastIndex] = y.toString()
                        z = 0.0
                    }
                    "/" -> {
                        z = if (list2.isEmpty()) list1[n3 - 1].toDouble() else list2[list2.lastIndex].toDouble()
                        y = z / list1[n3 + 1].toDouble()
                        if (list2.isEmpty()) list2.add(y.toString()) else list2[list2.lastIndex] = y.toString()
                        z = 0.0
                    }
                    "+" -> {
                        list2.add(list1[n3])
                        list2.add(list1[n3 + 1])
                    }
                    "-" -> {
                        list2.add(list1[n3])
                        list2.add(list1[n3 + 1])
                    }

                }
            }
        }
        if (list2.isEmpty()) list2 = list1
        if (list1.contains("+") || list1.contains("-")) {
            result = list2[0].toDouble()
            for (index in list2.indices) {
                when (list2[index]) {
                    "+" -> {
                        result += list2[index + 1].toDouble()
                    }
                    "-" -> {
                        result -= list2[index + 1].toDouble()
                    }
                    else -> Log.d("Xz", "затычка")
                }
            }

        }
        else result = list2.last().toDouble()
        if (floor(result) == result) {
            x=result.toInt().toString()
            return x
        } else {
            return result.toString()
        }
    }

    fun bindNum(num: Int, button: Button)= with((bindingClass)){
        button.setOnClickListener {
            if (showResult == "") showResult = if(num==0) "0." else "$num"
            else showResult += "$num"
            mainScrean2.text = reshi(showResult)
            mainScrean.text = showResult

        }
    }

    fun bindSign(sign: Char, button: Button)= with((bindingClass)){
        button.setOnClickListener {
            if (showResult == "") showResult = if(sign == '.') "0." else ""
            else
            when{showResult.last() == '-' ||
                    showResult.last() == '+' ||
                    showResult.last() == '/' ||
                    showResult.last() == '.' ||
                    showResult.last() == '*' -> Log.d("Xz", "затычка")
                else -> showResult += "$sign"
            }
              mainScrean.text = showResult
        }
    }

//dddd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindNum(1, bindingClass.but1)
        bindNum(2, bindingClass.but2)
        bindNum(3, bindingClass.but3)
        bindNum(4, bindingClass.but4)
        bindNum(5, bindingClass.but5)
        bindNum(6, bindingClass.but6)
        bindNum(7, bindingClass.but7)
        bindNum(8, bindingClass.but8)
        bindNum(9, bindingClass.but9)
        bindSign('+', bindingClass.butPlus)
        bindSign('-', bindingClass.butMinus)
        bindSign('/', bindingClass.butDell)
        bindSign('*', bindingClass.butUmn)
        bindSign('.', bindingClass.butPoint)

        bindingClass.but0.setOnClickListener {
            if(showResult == "") showResult = "0."
            else
            showResult += when{
                showResult.last() == '-' ||
                showResult.last() == '+' ||
                showResult.last() == '/' ||
                showResult.last() == '*' -> "0."
                else -> "0"
            }
            bindingClass.mainScrean2.text = reshi(showResult)
            bindingClass.mainScrean.text = showResult
        }

/*
        bindingClass.but2.setOnClickListener {
            if (showResult == ""){
                showResult = "2"
            } else {
            showResult += "2"
        }
            bindingClass.mainScrean.text = showResult
        }

        bindingClass.but3.setOnClickListener {

            if (showResult == "") {
                showResult = "3"
            } else {
                showResult += "3"
            }
            bindingClass.mainScrean.text = showResult
        }


        bindingClass.but4.setOnClickListener {

                if (showResult == "") {
                    showResult = "4"
                } else {
                    showResult += "4"
                }
            bindingClass.mainScrean.text = showResult
        }


        bindingClass.but5.setOnClickListener {

                if (showResult == "") {
                    showResult = "5"
                } else {
                    showResult += "5"
                }
            bindingClass.mainScrean.text = showResult
        }


        bindingClass.but6.setOnClickListener {

                if (showResult == "") {
                    showResult = "6"
                } else {
                    showResult += "6"
                }
            bindingClass.mainScrean.text = showResult

            }


            bindingClass.but7.setOnClickListener {
                if (showResult == "") {
                    showResult = "7"
                } else {
                    showResult += "7"
                }
                bindingClass.mainScrean.text = showResult

            }

            bindingClass.but8.setOnClickListener {
                if (showResult == "") {
                    showResult = "8"
                } else {
                    showResult += "8"
                }
                bindingClass.mainScrean.text = showResult

            }

            bindingClass.but9.setOnClickListener {
                if (showResult == "") {
                    showResult = "9"
                } else {
                    showResult += "9"
                }
                bindingClass.mainScrean.text = showResult

            }

            bindingClass.but0.setOnClickListener {
                if (showResult == "") {
                    showResult = "0."
                } else {
                    showResult += "0"
                }
                bindingClass.mainScrean2.text = reshi(showResult)
                bindingClass.mainScrean.text = showResult
            }

            bindingClass.butPlus.setOnClickListener {
                when{showResult.last() == '-' ||
                    showResult.last() == '+' ||
                    showResult.last() == '/' ||
                    showResult.last() == '*' -> Log.d("Xz", "затычка")
                           showResult == "" -> showResult == ""
                    else -> showResult += "+"
                }

                bindingClass.mainScrean.text = showResult

            }

            bindingClass.butMinus.setOnClickListener {
                if (showResult == "") {
                    showResult = "-"
                } else {
                    showResult += "-"
                }
                bindingClass.mainScrean.text = showResult
            }

                bindingClass.butPoint.setOnClickListener {
                    when {
                        showResult == "" -> showResult = "0."
                        showResult[showResult.length-1] == '.' -> Log.d("Xz", "затычка")
                        else -> showResult += "."
                    }

                    bindingClass.mainScrean.text = showResult
                }

                bindingClass.butUmn.setOnClickListener {
                    if (showResult == "") {
                        showResult = "*"
                    } else {
                        showResult += "*"
                    }
                    bindingClass.mainScrean.text = showResult
                }

                bindingClass.butDell.setOnClickListener {
                    if (showResult == "") {
                        showResult = "/"
                    } else {
                        showResult += "/"
                    }
                    bindingClass.mainScrean.text = showResult
                }

 */

       bindingClass.butDelete.setOnClickListener {
            if (showResult == "") {
                showResult = ""
            } else {
                showResult = showResult.dropLast(1)
            //showResult.droplast(1) showResult.substring(0, showResult.length-2)
            }
           bindingClass.mainScrean.text = showResult
                     // bindingClass.mainScrean2.text = history
        }


        bindingClass.butClean.setOnClickListener {
            if (showResult == "") {
                bindingClass.textStories.text = bindingClass.mainScrean2.text
                bindingClass.mainScrean.text = ""
                bindingClass.mainScrean2.text = ""
            } else {
                showResult = ""
            }
        }

        bindingClass.butReq.setOnClickListener {
            if(bindingClass.textStories.text != bindingClass.mainScrean2.text &&
                    bindingClass.mainScrean2.text != ""){
                bindingClass.textStories.text = bindingClass.mainScrean2.text
            }
            bindingClass.mainScrean2.text = reshi(showResult)
            showResult = ""
           bindingClass.mainScrean.text = showResult

        }

            }




}





