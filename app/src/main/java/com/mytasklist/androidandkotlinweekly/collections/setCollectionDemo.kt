package com.mytasklist.androidandkotlinweekly.collections

fun main(){
    //unionExample()
    //intersectExample()
    //partitionExampleSet()
    //subTrackExample()
    takeExampleSet()
}

// union: Returns a set containing all elements from both sets.
fun unionExample(){
    val set1:Set<Int> = setOf(1,2,3)
    val set2:Set<Int> = setOf(4,5,6,4,3)
    val unionSet:Set<Int> = set1 union set2
    println(unionSet) // Output: [1, 2, 3, 4, 5]
}

// intersect: Returns a set containing elements that are present in both sets.
fun intersectExample() {
    val set1: Set<Int> = setOf(1, 2, 3)
    val set2: Set<Int> = setOf(3, 4, 5)
    val intersectSet: Set<Int> = set1 intersect set2
    println(intersectSet)  // Output: [3]
}

// partition: Splits the set into two sets based on a predicate.
// The first set contains elements that match the predicate,
// and the second set contains elements that don’t.
fun partitionExampleSet() {
    val numbers: Set<Int> = setOf(1, 2, 3, 4, 5)
    val (evens, odds) = numbers.partition { it % 2 == 0 }
    println(evens)  // Output: [2, 4] println(odds)   // Output: [1, 3, 5]
}

// subtract: Returns a set containing elements that are present in the first set but not in the second.
fun subTrackExample(){
    val set1: Set<Int> = setOf(1, 2, 3)
    val set2: Set<Int> = setOf(3, 4, 5)
    val subtractSet: Set<Int> = set2 subtract set1
    println(subtractSet)  // Output: [1, 2]
}

// take: Returns a set containing the first n elements.
fun takeExampleSet() {
    val numbers: Set<Int> = setOf(1, 2, 3, 4, 5)
    val taken: Set<Int> = numbers.take(3).toSet()
    println(taken)  // Output: [1, 2, 3]
}

