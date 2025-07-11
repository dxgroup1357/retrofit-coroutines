package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
/**
 * Flow context
 *
 * Collection of a flow always happens in the context of the calling coroutine.
 * For example, if there is a simple flow, then the following code runs in the context specified by the author of this code,
 * regardless of the implementation details of the simple flow
 *
 */

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

private fun simple(): Flow<Int> = flow {
    log("Started simple flow")
    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    simple().collect { value -> log("Collected $value") }
}






