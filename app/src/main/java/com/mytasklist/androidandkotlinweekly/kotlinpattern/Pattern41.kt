package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    var calculate = 0
    for (i in 5 downTo 1) {

        for (j in i .. 4) {
            calculate +=1
            print("$calculate ")
        }
        println()
    }
}