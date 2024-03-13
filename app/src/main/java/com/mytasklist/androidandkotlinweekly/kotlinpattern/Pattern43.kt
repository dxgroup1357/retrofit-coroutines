package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    for (i in 1..5) {
        var t = i - 1
        for (j in 1..i) {
            val calculated = (t + i)
            print("$calculated ")
            t += 2
        }

        println()
    }
}