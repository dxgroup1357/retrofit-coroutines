package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    val n = 9
    var x = 0;
    for (i in  1..5){
        x = i
        for (j in 1..5){
            print("$x ")
            x+=n
        }
        println()
    }
}