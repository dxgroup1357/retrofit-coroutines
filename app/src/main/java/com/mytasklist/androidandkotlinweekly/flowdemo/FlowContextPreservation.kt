package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/*Kotlin Flow Context Preservation(Flow On)+ Exception Handling (Catch)*/
fun main() = runBlocking { // this: CoroutineScope
    launch (Dispatchers.Default){ // launch a new coroutine and continue
        producerData()
            .map {
                delay(1000)
                println("HappyCoding "+ " Map thread ${Thread.currentThread().name}")
                it * 2
            }
            //.flowOn(Dispatchers.IO) Not working here
            .filter {
                delay(500)
                println("HappyCoding "+"Filter thread ${Thread.currentThread().name}")
                it < 8
            }
           /// .flowOn(Dispatchers.Main) Not working here
            .collect{
               println("HappyCoding "+"Collector thread ${Thread.currentThread().name}")
            }
    }
    println("Hello Preservation Demo") // main coroutine continues while a previous one is delayed
}


fun producerData() : Flow<Int> {
    return flow {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        list.forEach {
            delay(1000)
            emit(it)
        }
    }
}