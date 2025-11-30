package com.mytasklist.androidandkotlinweekly.leetcode

fun main() {
    myAtoi("42").also { println(it) }
    myAtoi("-42").also { println(it) }
    myAtoi("42ghhh04").also { println(it) }
    myAtoi("42    hsiuhui89").also { println(it) }
}

fun myAtoi(s: String): Int {
    if (s.isEmpty()) return 0

    var index = 0
    val n = s.length

    // 1. Skip leading whitespaces
    while (index < n && s[index] == ' ') index++

    // If all spaces
    if (index == n) return 0

    // 2. Check sign
    var sign = 1
    if (s[index] == '+' || s[index] == '-') {
        sign = if (s[index] == '-') -1 else 1
        index++
    }

    var result = 0
    val INT_MAX = Int.MAX_VALUE      // +2^31 - 1 = 2147483647
    val INT_MIN = Int.MIN_VALUE      // -2^31    = -2147483648

    // 3. Convert digits and clamp on overflow
    while (index < n && s[index].isDigit()) {
        val digit = s[index] - '0'

        // Check overflow/underflow before multiplication
        if (result > INT_MAX / 10 || (result == INT_MAX / 10 && digit > INT_MAX % 10)) {
            return if (sign == 1) INT_MAX else INT_MIN
        }

        result = result * 10 + digit
        index++
    }

    return result * sign
}
