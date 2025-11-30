package com.mytasklist.androidandkotlinweekly.collections

fun main(){
    val stringMain = "a,b,c,d,e,f,g,f,g,a,d,b,c"
    val listItem = stringMain.split(",")
    val removeOldDuplicate = listItem.distinct()
    println(removeOldDuplicate)
}