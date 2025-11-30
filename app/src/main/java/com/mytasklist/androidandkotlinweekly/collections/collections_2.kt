package com.example.myapplication

fun main(){
    //countEvenNumber()
    //countOddNumbers()
    //squareEachNumber()
    //filterWordsStartWithA()
    //groupWordsByFirstLetter()
    //mapWordsToLength()
    //flattenListOfLists()
    //distinctElementsFromList()
    //sortStringByLenth()
    //takeFirst3Element()
    //dropFirst2Elements()
    //checkAllNumberPositive()
    //checkIfAnyNumberIsEven()
    //zipTwoList()
    //unZipOfTwoList()
    //partitionNumberIntoEvenOdd()
    maxNumber()
}

//23. Count even numbers
fun countEvenNumber(){
    val nums = listOf(1, 2, 3, 4, 5, 6)
    val resultCountNo= nums.filter { it%2==0 }
    println("result:$resultCountNo")
}

//24. Count odd numbers
fun countOddNumbers(){
    val nums = listOf(1, 2, 3, 4, 5, 6)
    val resultCountNo= nums.filter { it%2==1 }
    println("result:$resultCountNo")
}

//25. Square each number
fun squareEachNumber(){
    val nums = listOf(1, 2, 3, 4)
    println("result:${nums.map { it*it }}")
}

//26. Filter words starting with 'a'
fun filterWordsStartWithA(){
    val words = listOf("apple", "banana", "apricot", "cherry")
    val filterString = words.find { it.startsWith("a", ignoreCase = false)}
    println("result:$filterString")
}

//27. Group words by first letter
fun groupWordsByFirstLetter(){
    val words = listOf("apple", "apricot", "banana", "blueberry")
    val groupOfList = words.groupBy { it.first() }
    println("result:$groupOfList")
}

//28. Map words to lengths
fun mapWordsToLength(){
    val words = listOf("apple", "banana", "cherry")
    val result = words.map { it.length }
    println("result:$result")
}

//29. Flatten list of lists
fun flattenListOfLists(){
    val listOfLists = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
    val result = listOfLists.flatten()
    println("result:$result")
}

//30. Distinct elements from list
fun distinctElementsFromList(){
    val nums = listOf(1,2,2,3,4,4,5)
    println("result:${nums.distinct()}")
}


//31. Sort strings by length
fun sortStringByLenth(){
    val words = listOf("sun", "galaxy","moon", "star")
    val result = words.sortedBy{it.length}
    println("result:$result")
}

//32. Take first 3 elements
fun takeFirst3Element(){
    val nums = listOf(1,2,3,4,5)
    val result = nums.take(3)
    println("result:$result")
}

//33. Drop first 2 elements
fun dropFirst2Elements(){
    val nums = listOf(1,2,3,4,5)
    val result = nums.drop(2)
    println("result:$result")
}

//34. Check if all numbers > 0
fun checkAllNumberPositive(){
    val nums = listOf(1,2,3,-1)
    val result = nums.all{it>0}
    println("result:$result")
}


//35. Check if any number is even
fun checkIfAnyNumberIsEven(){
    val nums = listOf(1,3,5,8)
    val result = nums.all{it%2==0}
    println("result:$result")
}

//36. Zip two lists
fun zipTwoList(){
    val a = listOf(1,2,3)
    val b = listOf("a","b","c")
    val result = a.zip(b)
    println("result:$result")
}

//37. Unzip a list of pairs
fun unZipOfTwoList(){
    val dataItem = listOf(1 to "a", 2 to "b", 3 to "c")
    val (nums,string) = dataItem.unzip()
    println("nums:$nums")
    println("string:$string")
}

//38. Partition numbers into even/odd
fun partitionNumberIntoEvenOdd(){
    val nums = listOf(1,2,3,4,5,6)
    val (oddItem,evenItem) = nums.partition{ it% 2 == 0}
    println("oddItem:$oddItem")
    println("evenItem:$evenItem")
}

//39. Fold sum of numbers
fun foldOfNumbers(){
    val nums = listOf(1,2,3,4,5)
    val result = nums.fold(1){acc,item->acc+item}
    println("result:$result")
}
//
fun maxNumber(){
    var arr1=listOf(3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3)
    // a ( 5 times )
    val resultMap = arr1.groupingBy { it }.eachCount()
    println("result:${resultMap.filter { it.key == 'a'}}")
}

fun removeDuplicates() {
    val list = intArrayOf(1, 2, 3, 2, 4, 1, 5)
    val result = list.distinct()
    println("result:$result")
}

// 2. Convert an IntRange to a List and vice-versa.
fun intTiList() {
    val range = 1..5
    val mainList = range.toList()
    println("range:$mainList")

    val list = listOf(1, 2, 3, 4, 5)
    val range2 = mainList.toIntArray()
    println("range2:$range2")

    val listToRange = if (list.isNotEmpty() && list == (list.first()..list.last()).toList()) {
        list.first()..list.last()
    } else {
        null
    }

    println("listToRange:$listToRange")

}
