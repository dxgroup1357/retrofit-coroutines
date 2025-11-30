package com.mytasklist.androidandkotlinweekly.leetcode

fun main(){
var result = convert("PAYPALISHIRING",3)
    println(result)
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1 || numRows >= s.length) return s

    val rows = MutableList(minOf(numRows, s.length)) { StringBuilder() }
    var curRow = 0
    var goingDown = false

    for (c in s) {
        rows[curRow].append(c)
        if (curRow == 0 || curRow == numRows - 1) {
            goingDown = !goingDown
        }
        curRow += if (goingDown) 1 else -1
    }

    val result = StringBuilder()
    for (row in rows) {
        println("value:$row")
        result.append(row)
    }
    return result.toString()
}
