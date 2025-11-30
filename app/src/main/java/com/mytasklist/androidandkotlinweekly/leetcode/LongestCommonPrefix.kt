package com.mytasklist.androidandkotlinweekly.leetcode

fun main(){
    val stringArray = arrayOf("dog","racecar","car")
    val result = longestCommonPrefixNew(stringArray)
    println("result:$result")
}

fun longestCommonPrefix(str:Array<String>):String {
    if (str.isEmpty()) return ""

        for (i in str[0].indices){
            println(str[0].indices)
            val char = str[0][i]
            for (j in 1 until str.size){
                if(i>= str[j].length || str[j][i] != char){
                    return str[0].substring(0,i)
                }
            }
        }

    return str[0]
}

fun longestCommonPrefixNew(str:Array<String>):String {
    if (str.isEmpty()) return ""

    for(i in str[0].indices){
        //println(i)
        val char = str[0][i]
        for (j in 1 until str.size){
            if(i>= str[j].length || str[j][i]!=char){
                return str[0].substring(0,i)
            }
        }
    }

    return str[0]
}

/*
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    for (i in strs[0].indices) {
        val char = strs[0][i]
        for (j in 1 until strs.size) {
            if (i >= strs[j].length || strs[j][i] != char) {
                return strs[0].substring(0, i)
            }
        }
    }
    return strs[0]
}
*/
