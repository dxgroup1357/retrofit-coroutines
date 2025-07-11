package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.*
/**
 *Flow builders
 *
 * The flow { ... } builder from the previous examples is the most basic one.
 * There are other builders that allow flows to be declared:
 *
 * Various collections and sequences can be converted to flows using the
 * .asFlow() extension function.
 *
 * */


fun main() = runBlocking<Unit> {
    // Convert an integer range to a flow
    println("IntRange Print")
    (1..3).asFlow().collect { value -> println(value) }
    println("LongRange Print")
    (1L..3L).asFlow().collect { value -> println(value) }
}

