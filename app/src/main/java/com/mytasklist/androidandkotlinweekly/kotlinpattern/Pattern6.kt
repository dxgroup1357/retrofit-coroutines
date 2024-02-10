package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    var currentValue = 0
    for (i in  1..5){
        for (j in 1..5){
            currentValue += 1
            print("$currentValue ")
        }
        println()
    }
}