package com.mytasklist.androidandkotlinweekly.leetcode.strings

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * */

fun main(){
    //println(removeDuplicatesFinal(intArrayOf(1,1,2)))
    println(removeDuplicatesFinal(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
    //println(removeDuplicatesFinal(intArrayOf(1,1,2,2,2,3)))
}

fun removeDuplicatesTwo(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var i = 0
    for (j in 1 until nums.size) {
        if (nums[j] != nums[i]) {
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1  // number of unique elements
}


fun removeDuplicates(nums:IntArray):Int{
    var myArray = mutableSetOf<Int>()
    var count = 0
    for (i in nums){
        myArray.add(i)
    }

    for (i in myArray){
        count += 1
    }
    return count
}

fun removeDuplicatesFinal(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var i = 0
    for (j in 1 until nums.size) {
        println("item:${nums}")
        if (nums[i] != nums[j]) {
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}