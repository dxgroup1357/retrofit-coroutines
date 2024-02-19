package com.example.androidmaterialdesign.coroutinesdemos.context

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    println("My job is ${coroutineContext[Job]}")
}