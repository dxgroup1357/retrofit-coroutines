package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    var currentValue = 1
    for (i in  1..5){
        for (j in 1..5){
            val formattedString = String.format("%2d", currentValue)
            print("$formattedString ")
            currentValue += 2
        }
        println()
    }
}