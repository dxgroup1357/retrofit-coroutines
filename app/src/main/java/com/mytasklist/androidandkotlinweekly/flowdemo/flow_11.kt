package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
/**
 * Terminal flow operators
 *Terminal operators on flows are suspending functions that start a collection of the flow.
 * The collect operator is the most basic one, but there are other terminal operators, which can make it easier:
 */

/** Note:
 * Conversion to various collections like toList and toSet.
 *
 * Operators to get the first value and to ensure that a flow emits a single value.
 *
 * Reducing a flow to a value with reduce and fold.
 *
 * For example:
 * */

fun main() = runBlocking<Unit>{
    //callSumExample()
    //callStringExample()
    callCharactersExample()
}

fun callSumExample() = runBlocking{
    val sum  = (1..5).asFlow()
        .map { it * it } // squares of numbers from 1 to 5
        .reduce {a,b ->
            println("value of a: $a")
            println("value of b: $b")
            a + b
        }  // sum them (terminal operator)
    println(sum)
}

fun callStringExample() = runBlocking {
    val concatenatedString = listOf("Kotlin","Coroutines","Flow")
        .asFlow() //Convert the list of string to a Flow
        .reduce { acc, value -> "$acc $value" }

    println(concatenatedString)
}

fun callCharactersExample() = runBlocking {
    val concatenatedChars = listOf('H', 'e', 'l', 'l', 'o')
        .asFlow() // Convert the list of characters to a Flow
        .map { it.toString() } //If this line comment getting error
        .reduce { acc, value1 -> acc + value1 } // Concatenate characters

    println(concatenatedChars)
}





