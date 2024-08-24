package com.example.androidmaterialdesign.coroutinesdemos

import kotlinx.coroutines.*

fun main(){
    val TAG = "myTag"
    val job = GlobalScope.launch(Dispatchers.Default) {
        repeat(5)
        {
            println("Coroutines is still working:$it")
            // delay the coroutine by 1sec
            delay(500)
        }
    }
    runBlocking {
        // waiting for the coroutine to finish it's work
        println("Main Thread is Running:1")
        job.cancelAndJoin()
        println("Main Thread is Running")
    }
}