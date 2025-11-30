package com.mytasklist.androidandkotlinweekly.leetcode

fun main(){
    val result = longestPalindrome("babad")
   // val result1 = longestPalindrome("cbbd")
    println("result:$result")
    //println("result_1:$result1")
}

fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""

    var start = 0
    var end = 0

    fun expandAroundCenter(left: Int, right: Int) {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        // Now palindrome is from (l+1) to (r-1)
        if (end - start < r - l - 1) {
            start = l + 1
            end = r
        }
    }

    for (i in s.indices) {
        expandAroundCenter(i, i)      // For odd-length palindromes
        expandAroundCenter(i, i + 1)  // For even-length palindromes
    }
    return s.substring(start, end)
}
