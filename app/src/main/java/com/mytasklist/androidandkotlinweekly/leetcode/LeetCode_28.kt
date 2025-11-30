package com.mytasklist.androidandkotlinweekly.leetcode

 //28. Find the Index of the First Occurrence in a String

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * */

fun main(){
    println(strStr("hello", "ll"))  // → 2
    println(strStr("aaaaa", "bba")) // → -1
    println(strStr("sadbutsad", "sad")) // → 0
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    if (needle.length > haystack.length) return -1

    for (i in 0..haystack.length - needle.length) {
        if (haystack.substring(i, i + needle.length) == needle) {
            return i
        }
    }
    return -1
}