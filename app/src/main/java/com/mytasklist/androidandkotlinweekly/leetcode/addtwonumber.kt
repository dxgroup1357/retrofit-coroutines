package com.mytasklist.androidandkotlinweekly.leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
fun main() {
    val l1 = listToLinkedList(listOf(2, 4, 3))
    val l2 = listToLinkedList(listOf(5, 6, 4))
    val result = addTwoNumbers(l1, l2)
    println(linkedListToList(result))  // Output: [7, 0, 8]
}
fun listToLinkedList(list: List<Int>): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    for (num in list) {
        current.next = ListNode(num)
        current = current.next!!
    }
    return dummy.next
}

fun linkedListToList(node: ListNode?): List<Int> {
    val result = mutableListOf<Int>()
    var current = node
    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }
    return result
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p = l1
    var q = l2
    var carry = 0
    val dummyHead = ListNode(0)
    var current = dummyHead

    while (p != null || q != null || carry != 0) {
        val x = p?.`val` ?: 0
        val y = q?.`val` ?: 0
        val sum = x + y + carry
        carry = sum / 10

        current.next = ListNode(sum % 10)
        current = current.next!!

        p = p?.next
        q = q?.next
    }

    return dummyHead.next
}
