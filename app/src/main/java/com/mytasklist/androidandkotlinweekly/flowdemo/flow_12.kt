package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
/**
 * Flows are sequential
 *
 * Each individual collection of a flow is performed sequentially unless special operators that operate on multiple flows are used.
 * The collection works directly in the coroutine that calls a terminal operator. No new coroutines are launched by default.
 * Each emitted value is processed by all the intermediate operators from upstream to downstream and is then delivered to the terminal operator after.
 */


fun main() = runBlocking<Unit>{
    println("===========Filter Data wit: it%2 == 0=============")
    callFilterS1()

    println("===========Filter Data wit: it%5 == 0 ==============")
    callFilterS2()

}

private fun callFilterS1() = runBlocking {
    /*This filter operation passes only even numbers through the flow,
     i.e., it will keep 2 and 4 from the flow, because 2 % 2 == 0 and 4 % 2 == 0.
     Other numbers (1, 3, and 5) will be filtered out*/
    (1..5).asFlow()
        .filter {
            println("Filter $it")
            it%2 == 0
        }
        .map {
            println("map $it")
            "string $it"
        }
        .collect{
            println("Collect $it")
        }
}

private fun callFilterS2() = runBlocking {
    (1..5).asFlow()
        .filter {
            println("Filter $it")
            it%5 == 0
        }
        .map {
            println("map $it")
            "string $it"
        }
        .collect{
            println("Collect $it")
        }
}





