package com.mytasklist.androidandkotlinweekly.flowdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
/**
 * Composing multiple flows
 *
 * Zip
 *
 * Just like the Sequence.zip extension function in the Kotlin standard library,
 * flows have a zip operator that combines the corresponding values of two flows
 *
 */


fun main() = runBlocking<Unit>{
   // callTwoListInZip()
    //callFourListInZip()
    //callZipWithError()
    //callZipWithError()
    callZipWithArrayList()
}

fun callZipWithArrayList() {
    val nums = listOf(1, 2, 3)
    val strs = listOf("one", "two", "three")

    // Zip the lists and convert the result to an ArrayList
    val result: ArrayList<String> = nums.zip(strs) { n, s -> "$n -> $s" }
        .toCollection(ArrayList())  // Convert the zipped result to an ArrayList

    // Print the ArrayList
    println(result)
}

fun callZipWithError() = runBlocking {
    val nums1 = flowOf(1, 2, 3)
    val nums2 = flowOf(4, 5) // Shorter flow
    val strs1 = flowOf("one", "two", "three")
    val strs2 = flowOf("four") // Shorter flow

    combine(nums1, nums2, strs1, strs2) { n1, n2, s1, s2 ->
        "$n1, $n2 -> $s1, $s2"
    }.collect { println(it) }
}

fun callFourListInZip()= runBlocking {
    val nums1 = flowOf(1, 2, 3)         // First list of numbers
    val nums2 = flowOf(4, 5, 6)         // Second list of numbers
    val strs1 = flowOf("one", "two", "three")   // First list of strings
    val strs2 = flowOf("four", "five", "six")   // Second list of strings

    // Use nested zip to combine all four flows
    nums1.zip(nums2) { n1, n2 -> n1 to n2 }    // First combine nums1 and nums2
        .zip(strs1) { pair, s1 -> Triple(pair.first, pair.second, s1) } // Then add strs1
        .zip(strs2) { triple, s2 -> "${triple.first}, ${triple.second} -> ${triple.third}, $s2" } // Finally, add strs2
        .collect { println(it) }   // Collect and print the result

}

fun callTwoListInZip() = runBlocking{
    val nums = (1..3).asFlow()
    val strs = flowOf("one","two","three")
    nums.zip(strs){a,b->"$a $b" }
        .collect{
            println(it)
        }
}






