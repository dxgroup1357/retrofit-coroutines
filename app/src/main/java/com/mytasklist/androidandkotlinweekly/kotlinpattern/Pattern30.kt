package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main() {
    var char:Char ='A'
    for (i in 1..5) {
        for (j in 1.. 5) {
            print("$char ")
            char+=1
        }
        println()
    }
}