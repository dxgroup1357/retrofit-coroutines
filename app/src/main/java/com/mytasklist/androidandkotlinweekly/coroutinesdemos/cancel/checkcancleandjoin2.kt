package com.example.androidmaterialdesign.coroutinesdemos

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        println("Coroutine start")

        launch {
            try {
                println("Child coroutine start")
                delay(Long.MAX_VALUE)
                println("Child coroutine end")
            } catch (e: CancellationException) {
                println(e)
            }
        }
        println("Coroutine end")
    }
    println("Join")
    println("isActive:"+job.isActive)
    println("isCancelled:"+job.isCancelled)
    println("isCompleted:"+job.isCompleted)
    delay(1000)
    job.cancel()
    println("isActive_1:"+job.isActive)
    println("isCancelled_1:"+job.isCancelled)
    println("isCompleted_1:"+job.isCompleted)
    //delay(5000)
    println("Done")
}