package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
/**
 * Intermediate flow operators
 * Flows can be transformed using operators, in the same way as you would transform collections and sequences.
 *  Intermediate operators are applied to an upstream flow and return a downstream flow.
 *  These operators are cold, just like flows are. A call to such an operator is not a suspending function itself.
 *  It works quickly, returning the definition of a new transformed flow.
 *
 * */


suspend fun performRequest(request: Int): String {
    delay(1000) // imitate long-running asynchronous work
    return "response $request"
}

fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .map { request -> performRequest(request*2) }
        .collect { response -> println(response) }
}

