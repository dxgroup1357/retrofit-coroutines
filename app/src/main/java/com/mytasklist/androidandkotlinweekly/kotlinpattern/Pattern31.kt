package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {

    for (i in 'A'..'E') {
        var char:Char = i
        for (j in 'A'.. 'E') {
            print("$char ")
            char+=1
        }
        println()
    }
}