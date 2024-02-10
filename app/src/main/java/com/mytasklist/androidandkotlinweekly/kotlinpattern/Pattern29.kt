package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    for (i in 'E' downTo 'A') {
        for (j in 'E' downTo 'A') {
            print("$j ")
        }
        println()
    }
}