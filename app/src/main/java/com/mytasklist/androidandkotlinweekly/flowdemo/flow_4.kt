package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *
 *
 * */
fun main() = runBlocking<Unit> {
    launch {
        simpleFive().collect{ value -> println("other $value") }
    }
    
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3){
            println("I'm not blocked $k")
            delay(1000)
        }
    }

    // Collect the flow
    simpleFour().collect{value -> println(value) }
}

fun simpleFour(): Flow<Int> = flow{
    for(i in 1..3){
        delay(1000)  // pretend we are doing something useful here
        emit(i)  // emit next value
    }
}

fun simpleFive(): Flow<Int> = flow{
    for(i in 1..3){
        delay(1000)  // pretend we are doing something useful here
        emit(i)  // emit next value
    }
}