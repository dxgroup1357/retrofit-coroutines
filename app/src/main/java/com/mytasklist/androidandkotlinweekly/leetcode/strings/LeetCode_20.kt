package com.mytasklist.androidandkotlinweekly.leetcode.strings

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * */

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("([])"))
}

fun isValid(str: String): Boolean {
    var s = str
    while (true) {
        s = if (s.contains("()")) {
            s.replace("()", "")
        } else if (s.contains("{}")) {
            s.replace("{}", "")
        } else if (s.contains("[]")) {
            s.replace("[]", "")
        } else {
            return s.isEmpty()
        }
    }
}