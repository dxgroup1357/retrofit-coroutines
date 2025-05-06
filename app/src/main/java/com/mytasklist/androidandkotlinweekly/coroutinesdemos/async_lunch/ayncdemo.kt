package com.mytasklist.androidandkotlinweekly.coroutinesdemos.async_lunch

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    launch {
        printFollowers1()
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}
private suspend fun printFollowers1(){
    val job = CoroutineScope(Dispatchers.IO).async{
         getFBFollowers()
    }

    val job2 = CoroutineScope(Dispatchers.IO).async{
        getInstFollowers()
    }


    println("myTag:${job.await()} ${job2.await()}")
}

private suspend fun getFBFollowers():Int{
    delay(5000)
    return 54
}

private suspend fun getInstFollowers():Int{
    delay(1000)
    return 113
}