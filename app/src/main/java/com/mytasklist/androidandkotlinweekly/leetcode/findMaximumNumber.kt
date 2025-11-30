package com.mytasklist.androidandkotlinweekly.leetcode

fun main(){
    maxNumber()
}
fun maxNumber(){
    val itemList = arrayOf(1,5,10,18)
    itemList.sortDescending()
    println(itemList[0])
}