package com.example.androidmaterialdesign.coroutinesdemos

fun main(){
    fun String.addExclamation(): String {
        return "$this!"
    }
    val message = "Hello"
    val modifiedMessage = message.addExclamation() // Extension function usage
    println(modifiedMessage)
}