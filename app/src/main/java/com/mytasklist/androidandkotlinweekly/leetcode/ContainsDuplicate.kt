package com.mytasklist.androidandkotlinweekly.leetcode

fun main() {
    val result = containsDuplicateTwo(intArrayOf(1,2,3,1))
    println(result)
}

/**This approach Long process
 * If nums = intArrayOf(1, 2, 3, 4, ..., 100000, 1),
 * this code compares each number with all others = too many comparisons → TLE on Leetcode.
 * */
fun containsDuplicate(nums: IntArray): Boolean {
    for (i in nums) {
        var count = 0
        for (j in nums) {
            if (i == j) {
                count += 1
            }
        }

        if (count > 1) {
            return true
        }

    }
    return false
}

fun containsDuplicateTwo(nums: IntArray): Boolean {
    val seen = HashSet<Int>()
    for (num in nums) {
        if (!seen.add(num)) {
            return true
        }
    }
    return false
}