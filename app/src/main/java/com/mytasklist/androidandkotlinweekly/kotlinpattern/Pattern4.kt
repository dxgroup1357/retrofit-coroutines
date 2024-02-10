package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    for (i in 5 downTo 1){
        for (j in 1..5){
            print("$i ")
        }
        println()
    }
}