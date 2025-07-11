package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * Flows are cold
 *
 * Flows are cold streams similar to sequences — the code inside a flow builder does not run until the flow is collected.
 * This becomes clear in the following example:
 * */

fun simpleSix(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    val flow = simpleSix()
    println("Calling collect...")
    flow.collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }
}