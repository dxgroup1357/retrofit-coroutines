package com.example.androidmaterialdesign.coroutinesdemos.others

fun main(){

    fun getUserId(userId: UserId):String {
        return userId.value
    }
    val userId = UserId("hello")
    println(userId)
    val id: String = getUserId(userId)
    println(id) // Output: 123
}
inline class UserId(val value: String)