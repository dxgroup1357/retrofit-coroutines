package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    for (i in 0..4) {
        for (j in 0..4) {
            val calculateValue = i % 2
            print("$calculateValue ")
        }
        println()
    }
}