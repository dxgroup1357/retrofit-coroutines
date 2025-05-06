package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        getUserNames().forEach {
            println("$it")
        }
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}

private suspend fun getUserNames(): List<String> {
    val list = mutableListOf<String>()
    list.add(getUserId(1))
    list.add(getUserId(2))
    list.add(getUserId(3))
    return list
}

private suspend fun getUserId(id: Int): String {
    delay(1000)// Assume Network Call
    return "User $id"
}


fun producer() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    list.forEach {
        delay(1000)
        emit(it)
    }
}