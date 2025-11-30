package com.mytasklist.androidandkotlinweekly.leetcode

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * */


import com.google.gson.Gson

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5)
    val target = 9

    val result = twoSum(nums, target)
    println("Sample One: ${Gson().toJson(result)}")
    //println("Sample One: ${result[1]}")
}

/*this answer accepted on leet code*/
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for ((index, num) in nums.withIndex()) {
        val complement = target - num
        if (map.containsKey(complement)) {
            println("findValue:${map[complement]!!}")
            return intArrayOf(map[complement]!!, index)
        }
        map[num] = index
        println("map$map")
    }

    return intArrayOf() // Return null if no pair is found
}

/*This answer not accepted on leet code*/
fun twoSumsThird(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val remainValue: Int = target - nums[i]

        for (j in nums.indices) {
            val jValue = nums[j]
            if (jValue == remainValue) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf() //Return null if it's not found value.
}

fun twoSumFourth(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val remainValue = target - nums[i]
        if (map.containsKey(remainValue)) {
            return intArrayOf(nums[remainValue], i)
        }
        map[i]=nums[i]
    }
    return intArrayOf()


}