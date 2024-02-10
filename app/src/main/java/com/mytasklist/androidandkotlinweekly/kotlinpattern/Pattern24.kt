package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    for (i in 1..5) {
        for (j in 0..4) {
            val calculateValue = j % 2
            print("$calculateValue ")
        }
        println()
    }
}