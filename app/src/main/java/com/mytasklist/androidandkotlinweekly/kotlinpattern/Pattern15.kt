package com.mytasklist.androidandkotlinweekly.kotlinpattern

fun main(){
    val n = 5
    var x = 0
    var y = 0
    for (i in 1..n){
        x = i
        y = n-i+1
        for (j in 1..5){
            if( j%2 == 0){
                print("$x ")
            } else {
                print("$y ")
            }
            x += n
            y += n
        }
        println()
    }
}