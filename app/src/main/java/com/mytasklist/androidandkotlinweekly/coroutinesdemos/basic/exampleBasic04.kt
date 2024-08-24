package com.example.androidmaterialdesign.coroutinesdemos

import kotlinx.coroutines.*

// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    doWorld4()
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld4() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}