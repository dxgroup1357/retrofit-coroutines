package com.example.androidmaterialdesign.coroutinesdemos.cancel


import kotlinx.coroutines.*

var acquired10 = 0

class Resource10 {
    init { acquired10++ } // Acquire the resource
    fun close() { acquired10-- } // Release the resource
}

fun main() {
    runBlocking {
        repeat(10_000) { // Launch 10K coroutines
            launch {
                var resource: Resource? = null // Not acquired yet
                try {
                    withTimeout(60) { // Timeout of 60 ms
                        delay(50) // Delay for 50 ms
                        resource = Resource() // Store a resource to the variable if acquired
                    }
                    // We can do something else with the resource here
                } finally {
                    resource?.close() // Release the resource if it was acquired
                }
            }
        }
    }
    // Outside of runBlocking all coroutines have completed
    println(acquired10) // Print the number of resources still acquired
}