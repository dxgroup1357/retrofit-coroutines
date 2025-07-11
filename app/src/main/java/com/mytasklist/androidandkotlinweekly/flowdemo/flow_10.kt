package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
/**
 * Size-limiting operators
 *
 * Size-limiting intermediate operators like take cancel the execution of the flow when the corresponding limit is reached.
 * Cancellation in coroutines is always performed by throwing an exception, so that all the resource-management functions (like try { ... } finally { ... } blocks) operate normally in case of cancellation
 * */

fun numbers(): Flow<Int> = flow{
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in number")
    }
}

fun main() = runBlocking<Unit>{
    /*numbers()
        .take(2) //taken only first two
        .collect{value-> println(value) }*/

    stringArrayData()
        .take(2)
        .collect{value-> println(value) }
}

fun stringArrayData(): Flow<String> = flow{
    try {
        emit("Hello 1")
        emit("Hello 2")
        println("This line will not execute")
        emit("Hello 3")
    } finally {
        println("Finally in number")
    }
}



