package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * Conflation
 *
 * In Kotlin's Flow, when you have a flow that emits a lot of values quickly, but the collector (the part that processes the emitted values) is slow, some values might pile up and cause delays.
 * The conflate operator helps in such situations by skipping intermediate values and only keeping the most recent value.
 */
private fun simple(): Flow<Int> = flow {
    for (i in 1..5) {
        //delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    val time = measureTimeMillis {
        simple()
            .conflate() // conflate emissions, don't process each one
            .collect { value ->
                delay(500) // pretend we are processing it for 300 ms
                println(value)
            }
    }
    println("Collected in $time ms")
}






