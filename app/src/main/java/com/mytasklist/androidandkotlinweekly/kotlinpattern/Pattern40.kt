package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {

    for (i in 5 downTo 1) {
        var calculate = 0
        for (j in i .. 5) {
            calculate +=2
            print("$calculate ")
        }
        println()
    }
}