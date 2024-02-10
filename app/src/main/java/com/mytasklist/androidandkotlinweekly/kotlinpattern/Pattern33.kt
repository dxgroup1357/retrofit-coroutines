package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {

    for (i in 'E' downTo 'A') {
        var char:Char = i
        for (j in 'A'.. 'E') {
            print("$char ")
            char+=5
        }
        println()
    }
}