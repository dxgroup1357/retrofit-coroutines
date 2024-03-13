package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    for (i in 1..5) {

        for (j in 1 ..i ) {
            val calculated = (i+j)-1
            print("$calculated ")
        }
        println()
    }
}