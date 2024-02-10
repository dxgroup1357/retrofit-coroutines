package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    var currentValue = 0
    for (i in  1..5){
        for (j in 1..5){
            currentValue += 2
            val formattedString = String.format("%2d", currentValue)
            print("$formattedString ")
        }
        println()
    }
}