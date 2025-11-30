package com.mytasklist.androidandkotlinweekly.leetcode

fun main(){
val result = isPowerOfTwo3(1073741825)
    println("result:$result")
}

fun isPowerOfTwo(n:Int):Boolean{
    var i =1
    while (i<n){
        i *= 2
    }

    return i==n
}

fun isPowerOfTwo1(n: Int): Boolean {
    if (n <= 0) return false
    var i = 1
    while (i < n) {
        i *= 2
    }
    return i == n
}


//Working in
fun isPowerOfTwo3(n: Int): Boolean {
    return n > 0 && (n and (n - 1)) == 0
}

