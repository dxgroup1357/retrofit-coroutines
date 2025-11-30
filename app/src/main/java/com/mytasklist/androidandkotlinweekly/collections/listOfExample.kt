package com.mytasklist.androidandkotlinweekly.collections

fun main () {
    takeLastExample()
    println("Map example: ")
    mapExample()
    println("Filter example: ")
    filterExample()
    println("Reduce example: ")
    reduceExample()
    println("Fold example: ")
    foldExample()
    println("GroupBy example: ")
    groupByExample()
    println("Flatten example: ")
    flattenExample()
    println("Chunked example: ")
    chunkedExample()
    println("Associate example: ")
    associateExample()
    println("Distinct example: ")
    distinctExample()
    println("Sorted example: ")
    sortedExample()
    println("Any example: ")
    anyExample()
    println("All example: ")
    allExample()
    println("None example: ")
    noneExample()
    println("Find example: ")
    findExample()
    println("Sum example: ")
    sumExample()
    println("Count example: ")
    countExample()
    println("Zip example: ")
    zipExample()
    println("Partition example: ")
    partitionExample()
    println("Drop example: ")
    dropExample()
    println("DropLast example: ")
    dropLastExample()
    println("Take example: ")
    takeExample()
    println("TakeLast example: ")
    takeLastExample()

    println("flatten Example WithString example: ")
    flattenExampleWithString()
}

// map: Transforms each element in the list.
fun mapExample() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    val doubled: List<Int> = numbers.map { it * 2 }
    println(doubled)  // Output: [2, 4, 6, 8, 10]
}

// filter: Filters elements based on a condition.
fun filterExample() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    val evenNumbers: List<Int> = numbers.filter { it % 2 == 0 }
    println(evenNumbers)  // Output: [2, 4]
}

// reduce: Combines all elements into a single result by applying
// a function that takes two parameters:
// the accumulator and the current element.
fun reduceExample(){
    val number:List<Int> = listOf(5,4,3,2,1)
    val sum = number.reduce{
                           acc,num-> acc+num
       /* println("acc:$acc")
        println("num:$num")
        println("=========")*/
    }
    println(sum)
}

// fold: Similar to reduce, but starts with an initial value
fun foldExample(){
    val number:List<Int> = listOf(1,2,3,4,5)
    val sumWithInitial:Int = number.fold(0){acc,num->acc+num }
    println(sumWithInitial)
}

//groupBy: Groups elements by a specific key.
fun groupByExample(){
    val names:List<String> = listOf("Anitta","Divya","Raj","Alan","Sara")
    val groupByFirstLetter:Map<Char,List<String>> = names.groupBy { it.first() }
    val groupByLastLetter:Map<Char,List<String>> = names.groupBy { it.last() }
    println(groupByFirstLetter)
    println(groupByLastLetter)
}

//chunked: Split a list into smaller list of a given size.
fun chunkedExample(){
    val numbers:List<Int> = (1..10).toList()
    val chunked:List<List<Int>> = numbers.chunked(3)
    println(chunked)
}

// associate: Transforms a collection into a map by applying a function to each element.
fun associateExample(){
    val names:List<String> = listOf("Anitta","Divya","Raj","Alan","Sara")
    val nameLengthMap:Map<String,Int> = names.associate { it to it.length }
    println(nameLengthMap)
}

// distinct: Returns a list containing only distinct elements.
fun distinctExample(){
    val number:List<Int> = listOf(1,2,1,3,1,5,6,7,2)
    val distinctNumbers:List<Int> = number.distinct()
    println(distinctNumbers)
}

//sorted: Returns a list with elements sorted in natural order
fun sortedExample(){
    val number:List<Int> = listOf(5,7,1,9,2)
    val sortedNumber:List<Int> = number.sorted()
    val sortedDescending:List<Int> = number.sortedDescending()
    println("sortedNumber:$sortedNumber")
    println("sortedDescending:$sortedDescending")
}

// any: Checks if any elements match a given condition.
fun anyExample(){
    val number:List<Int> = listOf(1,9,3,7,5)
    val hasEven:Boolean = number.any{it%2==0}
    println(hasEven)
}

// all: Checks if all elements match a given condition.
fun allExample() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    val allEven: Boolean = numbers.all { it % 2 == 0 }
    println(allEven)  // Output: false
}

// none: Checks if no elements match a given condition.
fun noneExample() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    val noneEven: Boolean = numbers.none { it % 2 == 0 }
    println(noneEven)  // Output: false
}

//find: Finds the first element that matches a condition
fun findExample(){
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    val firstEven:Int?= numbers.find { it%2==0 }
    println(firstEven)
}

//sum:Return the sum of all elements.
fun sumExample(){
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    val totalSum:Int = numbers.sum()
    println(totalSum)
}

//count: returns the number of elements that match a condition.
fun countExample(){
    val number:List<Int> = listOf(1,2,3,4,5)
    val countNumber = number.count { it%2==0 }
    println(countNumber)
}

//Zip: Merges two into a list of pairs
fun zipExample(){
    val number1:List<Int> = listOf(1,2,3)
    val number2:List<Int> = listOf(4,5,6)
    val zipped:List<Pair<Int,Int>> = number1.zip(number2)
    println(zipped)

}

// partition: Splits the list into two lists based on a predicate.
// The first list contains elements that match the predicate,
// and the second list contains elements that don’t.
fun partitionExample(){
    val number:List<Int> = listOf(1,2,3,4,5)
    val(even,odds) = number.partition { it % 2 == 0 }
    println(even)
    println(odds)
}

// drop: Returns a list containing all elements except the first n elements.
fun dropExample(){
    val number:List<Int> = listOf(1,2,3,4,5)
    val droppedLast:List<Int> = number.drop(2)
    println(droppedLast)
}

// dropLast: Returns a list containing all elements except the last n elements.
fun dropLastExample(){
    val number:List<Int> = listOf(1,2,3,4,5)
    val droppedLast:List<Int> = number.dropLast(2)
    println(droppedLast)
}

//take: Returns a list containing the first n elements
fun takeExample(){
    val number:List<Int> = listOf(1,2,3,4,5)
    val taken:List<Int> = number.take(2)
    println(taken)
}

//takeLast: Returns a list containing the last n elements
fun takeLastExample(){
    val number:List<Int> = listOf(1,2,3,4,5)
    val taken:List<Int> = number.takeLast(2)
    println(taken)
}

// flatten: Flattens a list of lists into a single list.
fun flattenExample() {
    val nestedList: List<List<Int>> = listOf(listOf(1, 2, 3), listOf(4, 5), listOf(6, 7, 8))
    val flattenedList: List<Int> = nestedList.flatten()
    println(flattenedList)  // Output: [1, 2, 3, 4, 5, 6, 7, 8]
}

// flatten: Flattens a list of lists into a single list.
fun flattenExampleWithString() {
    val nestedList: List<List<String>> = listOf(listOf("aaa","bbb","cc","zz"), listOf("dd","ee"))
    val flattenedList: List<String> = nestedList.flatten()
    println(flattenedList)  // Output: [1, 2, 3, 4, 5, 6, 7, 8]
}



