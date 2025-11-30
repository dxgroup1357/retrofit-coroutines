package com.mytasklist.androidandkotlinweekly.leetcode

/**
 * Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 * */
fun main(){
    val (l1, l2) = createSampleLists()
    val merged = mergeTwoLists(l1, l2)
    printList(merged)

}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var dummy = ListNode(0)
    var current  = dummy
    var l1 = list1
    var l2 = list2

    while(l1!=null && l2!=null){
        //Merge List
        if(l1.`val`<=l2.`val`){
            current.next=l1
            l1 = l1.next
        }else{
            current.next=l2
            l2 = l2.next
        }
        current = current.next!!

    }
    //Attach remaining part
    current.next = l1?: l2
    return dummy.next

}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

fun createSampleLists(): Pair<ListNode?, ListNode?> {
    // First list: 1 -> 3
    val l1 = ListNode(1)
    l1.next = ListNode(3)

    // Second list: 2 -> 4
    val l2 = ListNode(2)
    l2.next = ListNode(4)

    return Pair(l1, l2)
}
