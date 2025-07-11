package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
/**
 *flowOn operator
 */

private fun simple(): Flow<Int> = flow {
    // The WRONG way to change context for CPU-consuming code in flow builder
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it in CPU-consuming way
        log("Emitting $i")
        emit(i) // emit next value
    }
}.flowOn(Dispatchers.Default)  // RIGHT way to change context for CPU-consuming code in flow builder

fun main() = runBlocking<Unit>{
    simple().collect { value ->
        log("Collected $value")
    }
}





