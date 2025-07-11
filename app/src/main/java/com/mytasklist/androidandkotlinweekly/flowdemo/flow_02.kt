package com.mytasklist.androidandkotlinweekly.flowdemo

/*If we are computing the numbers with some
CPU-consuming blocking code (each computation taking 100ms),
then we can represent the numbers using a*/
fun main() {
    simple1().forEach { value -> println(value) }
}

fun simple1(): Sequence<Int> = sequence { //Sequence Builder
    for(i in 1..3){
        Thread.sleep(100)  // pretend we are computing it
        yield(i)  // yield next value
    }
}