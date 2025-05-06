package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.System.currentTimeMillis

/**
 *Combine
 *
 */


fun main() = runBlocking<Unit>{

    val nums = (1..3).asFlow().onEach { delay(300) }
    val strs = flowOf("one","two","three")
    val startTime = currentTimeMillis()
    nums.zip(strs){a,b-> "$a $b" }
        .collect{value->
            println("$value at ${currentTimeMillis() - startTime}) ms from start")
        }

}






