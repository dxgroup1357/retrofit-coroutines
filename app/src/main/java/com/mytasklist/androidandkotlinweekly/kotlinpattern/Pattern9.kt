package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    for (i in  1..5){
        for (j in 1..5){
            //val calculateValue = i*j
            //val formattedString = String.format("%2d", "$calculateValue")
            print("${i*j} ")
        }
        println()
    }
}