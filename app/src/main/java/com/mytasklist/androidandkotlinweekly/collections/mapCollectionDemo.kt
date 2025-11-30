package com.mytasklist.androidandkotlinweekly.collections

fun main(){
    println("MapValues example: ")
    mapValuesExample()
    println("MapKeys example: ")
    mapKeysExample()
    println("FilterKeys example: ")
    filterKeysExample()
    println("FilterValues example: ")
    filterValuesExample()
    println("toList example: ")
    toListExample()
    println("Merge example: ")
    mergeExample()
}

// mapValues: Transforms the values in the map.
fun mapValuesExample(){
    val map:Map<String,Int> = mapOf("a" to 1,"b" to 2,"c" to 3)
    val doubleValues:Map<String,Int> = map.mapValues { it.value * 2}
    println(doubleValues)
}

// mapKeys: Transforms the keys in the map.
fun mapKeysExample(){
    val map:Map<String,Int> = mapOf("a" to 1,"b" to 2,"c" to 3)
    val doubleValues:Map<String,Int> = map.mapKeys { it.key.uppercase()}
    println(doubleValues)
}

// filterKeys: Filters the keys in the map.
fun filterKeysExample() {
    val map: Map<String, Int> = mapOf("a" to 1, "b" to 2, "c" to 3)
    val filteredKeys: Map<String, Int> = map.filterKeys { it > "a" }
    println(filteredKeys)  // Output: {b=2, c=3}
}

// filterValues: Filters the keys in the map.
fun filterValuesExample() {
    val map: Map<String, Int> = mapOf("a" to 1, "b" to 2, "c" to 3)
    val filteredKeys: Map<String, Int> = map.filterValues { it > 1}
    println(filteredKeys)  // Output: {b=2, c=3}
}

// toList: Converts the map to a list of pairs.
fun toListExample() {
    val map: Map<String, Int> = mapOf("a" to 1, "b" to 2, "c" to 3)
    val filteredKeys: List<Pair<String, Int>> = map.toList()
    println(filteredKeys)  // Output: {b=2, c=3}
}

// merge: Merges another map into this map, applying the given function to the values of matching keys.
fun mergeExample() {
    val map1: MutableMap<String, Int> = mutableMapOf("a" to 1, "b" to 2)
    val map2: Map<String, Int> = mapOf("b" to 3, "c" to 4)
    map2.forEach { key, value -> map1.merge(key, value, Int::plus) }
    println(map1)  // Output: {a=1, b=5, c=4}
}