package com.mytasklist.androidandkotlinweekly.collections

fun main() {
    intTiList()
}

// 2. Convert an IntRange to a List and vice-versa.
fun intTiList() {
    val range = 1..5
    val mainList = range.toList()
    println("range:$mainList")

    val list = listOf(1, 2, 3, 4, 5)
    val range2 = mainList.toIntArray()
    println("range2:$range2")

    val listToRange = if (list.isNotEmpty() && list == (list.first()..list.last()).toList()) {
        list.first()..list.last()
    } else {
        null
    }

    println("listToRange:$listToRange")

}