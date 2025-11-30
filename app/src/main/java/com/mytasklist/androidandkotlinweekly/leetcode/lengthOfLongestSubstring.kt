package com.mytasklist.androidandkotlinweekly.leetcode


fun main(){
   //val lengthString =  lengthOfLongestSubstring("abcabcbb")
   //val lengthStringSecond =  lengthOfLongestSubstringSecond("abcabcbb")
    val lengthStringSecond =  lengthOfStringFourth("abcedabvni")
    println("lengthStringSecond:$lengthStringSecond")
}

fun lengthOfLongestSubstring(s: String): Int {
    var left = 0
    var maxLength = 0
    val seen = mutableSetOf<Char>()

    for (right in s.indices) {
        while (s[right] in seen) {
            seen.remove(s[left])
            left++
        }
        seen.add(s[right])
        maxLength = maxOf(maxLength, right - left + 1)
        println("maxLength:$maxLength")
        println("seen:$seen")
        println("right:$right, left:$left")
    }

    return maxLength
}

fun lengthOfLongestSubstringSecond(s: String): Int {
    val lastSeen = mutableMapOf<Char, Int>()
    var maxLen = 0
    var start = 0

    for ((i, c) in s.withIndex()) {
        if (c in lastSeen && lastSeen[c]!! >= start) {
            start = lastSeen[c]!! + 1
        }
        lastSeen[c] = i
        maxLen = maxOf(maxLen, i - start + 1)

       //println("i:$i, c:$c")
        println("start:$start, lastSeen:$lastSeen")
    }

    return maxLen
}

fun lengthOfLongestSubstringThird(s:String):Int{
    var start = 0
    var end = 0
    var max_length = 0
    val list = mutableListOf<Char>()

    while (end<s.length){
        if(!list.contains(s[end])) {
            list.add(s[end])
            end++
            max_length = Math.max(max_length,list.size)
        } else {
            list.remove(s[start])
            start++
        }
    }
    println("max_length:$max_length")
    return 0
}

fun lengthOfStringFourth(s:String):Int{
    var start = 0
    var end = 0
    var max_length = 0
    var list = mutableListOf<Char>()

    while (end<s.length){
        if(!list.contains(s[end])){
            list.add(s[end])
            end++
            max_length = Math.max(max_length,list.size)
        } else {
            list.remove(s[start])
            start++
        }
    }
    return max_length
}

