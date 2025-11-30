package com.mytasklist.androidandkotlinweekly.leetcode
/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * */

fun main(){
    println(lengthOfLastWordNew("Hello World  "))                    // 5
    println(lengthOfLastWordNew("   fly me   to   the moon  "))    // 4
    println(lengthOfLastWordNew("a "))
}

fun lengthOfLastWord(s:String):Int{

    var i = s.length-1
    var length = 0

    //Skip trailing spaces
    while (i>=0 && s[i]== ' '){
        i--
    }

    while (i>=0 && s[i]!= ' '){
        length++
        i--
    }

    return length
}

fun lengthOfLastWordNew(s:String):Int{
    var i= s.length-1
    var length = 0

    while (i>=0 && s[i] == ' '){
        i--
    }

    while (i>=0 && s[i] != ' '){
        length++
        i--
    }

    return length
}