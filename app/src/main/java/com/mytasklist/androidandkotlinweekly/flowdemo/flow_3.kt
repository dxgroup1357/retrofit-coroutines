package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * However, this computation blocks the main thread that is running the code.
 * When these values are computed by asynchronous code we can mark the simple function with a suspend modifier, so that it can perform its work without blocking and return the result as a list:
 * */
fun main() = runBlocking<Unit> {
    simple3().forEach { value -> println(value) }
}

suspend fun simple3(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}