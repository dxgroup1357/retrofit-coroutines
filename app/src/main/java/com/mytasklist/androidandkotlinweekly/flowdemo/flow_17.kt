package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * Buffering
 */
private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    val time = measureTimeMillis {
        simple()
            .buffer() // buffer emissions, don't wait
            .collect { value ->
                delay(500) // pretend we are processing it for 500 ms
                println(value)
            }
    }
    println("Collected in $time ms")
}






