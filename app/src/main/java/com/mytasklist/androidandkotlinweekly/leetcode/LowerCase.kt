package com.mytasklist.androidandkotlinweekly.leetcode

fun main(){
//val result = toLowerCase("Hello")
val resultTwo = toLowerCaseTwo("Hello")
    println("result:$resultTwo")
}

fun toLowerCase(s: String): String {

    val c = s.toCharArray()
    for (i in c.indices){
        /*if(c[i]>=65 && c[i]<=97){

        }*/
        println("c:$i")
    }
    return c.toString()
}

fun toLowerCaseTwo(s: String): String {
    val result = StringBuilder()
    for (c in s){
        if(c in 'A'..'Z'){
            result.append(c+32)
        }else{
            result.append(c)
        }
    }

    return result.toString()
}

