package com.mytasklist.androidandkotlinweekly.coroutinesdemos.async_lunch

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
       printFollowers()
    }
}*/

private suspend fun printFollowers(){
    var fbFollowers = 0
    var instaFollowers = 0
    val job = CoroutineScope(Dispatchers.IO).launch{
        fbFollowers = getFBFollowers()
    }

    val job2 = CoroutineScope(Dispatchers.IO).launch{
        instaFollowers = getInstFollowers()
    }

    job.join()
    job2.join()
    println("myTag:$fbFollowers $instaFollowers")
}

private suspend fun getFBFollowers():Int{
    delay(1000)
    return 54
}

private suspend fun getInstFollowers():Int{
    delay(1000)
    return 113
}