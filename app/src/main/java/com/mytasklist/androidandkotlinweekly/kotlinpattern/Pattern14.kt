package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    val n = 5
    var x = 0
    for (i in 1..n){
        x = n-i+1
        for (j in 1..5){
            print("$x ")
            x+=n
        }
        println()
    }
}