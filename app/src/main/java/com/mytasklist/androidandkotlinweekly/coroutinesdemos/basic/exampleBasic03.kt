package com.example.androidmaterialdesign.coroutinesdemos


import kotlinx.coroutines.*

fun main() = runBlocking {
    doWorld3()
}

suspend fun doWorld3() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World Example_3!")
    }
    println("Hello")
}