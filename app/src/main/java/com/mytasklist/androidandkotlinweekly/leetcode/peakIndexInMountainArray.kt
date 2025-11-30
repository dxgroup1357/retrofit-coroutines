package com.mytasklist.androidandkotlinweekly.leetcode

fun main(){
val result = peakIndexInMountainArray(intArrayOf(0,10,5,10,2))
    println("result:$result")
}

fun peakIndexInMountainArray(arr: IntArray): Int {
    for (i in 1 until arr.size - 1) {
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
            return i
        }
    }
    return -1
}