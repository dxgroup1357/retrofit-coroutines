package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Processing the latest value
 *
 */

private fun simple(): Flow<Int> {
    return (1..5).asFlow()
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple()
            .collectLatest { value ->
                println("Collecting $value")
                delay(500)
                println("Done $value")
            }
    }
    println("Collect in $time ms")

}






