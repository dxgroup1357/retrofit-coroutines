package com.mytasklist.androidandkotlinweekly.flowdemo

fun simpleIntList(): List<Int> = listOf(1,2,3)
fun simpleStringList(): List<String> = listOf("Kotlin", "Coroutines", "Flow")
fun main() {
    println("Simple Int List")
    //simpleIntList().forEach { value -> println(value) }
    println("Simple String ArrayList")
   // simpleStringList().forEach { value -> println(value) }
    println("Simple Ascii ArrayList")
    //asciiArrayList()

    println("======Ascii Value==1..90======")
    //asciiArrayListOther()
    println("======Ascii Value after 90..120======")
    //asciiArrayListAfter100()
    println("======Ascii Value after 121..200======")
    //asciiArrayListAfter120()
    println("======Ascii Value after 1..500======")
    asciiArrayListAfterOneFive()

}

fun asciiArrayList(): ArrayList<Char> {
    // Create an ArrayList to store ASCII characters
    val asciiList = ArrayList<Char>()

    // Add ASCII characters for values from 65 to 90 (A to Z)
    for (i in 65..90) {
        asciiList.add(i.toChar()) // Convert the ASCII value to its corresponding character
    }

    // Print the ASCII ArrayList
    println(asciiList)
    return asciiList
}

fun asciiArrayListOther(): ArrayList<Char> {
    // Create an ArrayList to store ASCII characters
    val asciiList = ArrayList<Char>()

    // Add ASCII characters for values from 65 to 90 (A to Z)
    for (i in 1..90) {
        asciiList.add(i.toChar()) // Convert the ASCII value to its corresponding character
    }

    // Print the ASCII ArrayList
    println(asciiList)
    return asciiList
}

fun asciiArrayListAfter100(): ArrayList<Char>{
    // Create an ArrayList to store ASCII characters
    val asciiList = ArrayList<Char>()

    // Add ASCII characters for values from 65 to 90 (A to Z)
    for (i in 91..120) {
        asciiList.add(i.toChar()) // Convert the ASCII value to its corresponding character
    }

    // Print the ASCII ArrayList
    println(asciiList)
    return asciiList
}

fun asciiArrayListAfter120(): ArrayList<Char>{
    val asciiList = ArrayList<Char>()
    for (i in 121..200) {
        asciiList.add(i.toChar()) // Convert the ASCII value to its corresponding character
    }
    println(asciiList)
    return asciiList
}

fun asciiArrayListAfterOneFive(): ArrayList<Char>{
    val asciiList = ArrayList<Char>()
    for (i in 1..100000) {
        asciiList.add(i.toChar()) // Convert the ASCII value to its corresponding character
    }
    println(asciiList)
    return asciiList
}