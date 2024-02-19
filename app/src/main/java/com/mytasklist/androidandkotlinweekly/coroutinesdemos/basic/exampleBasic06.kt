package com.example.androidmaterialdesign.coroutinesdemos

import kotlinx.coroutines.*

fun main() = runBlocking {
    //Coroutines are light-weight
    repeat(50_000) { count->// launch a lot of coroutines
        launch {
            delay(500L)
            print(".")
            print(count)
        }
    }
}

/*
fun main()  {
    for (x in 0.. 50000) {
        Thread.sleep(500)
        print(".")
        println(x)
    }
}*/
