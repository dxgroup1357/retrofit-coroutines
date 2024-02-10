package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    for (i in 1..5) {
        var x =0
        for (j in 0..4) {
           x = i+j
            print("$x ")
        }
        println()
    }
}