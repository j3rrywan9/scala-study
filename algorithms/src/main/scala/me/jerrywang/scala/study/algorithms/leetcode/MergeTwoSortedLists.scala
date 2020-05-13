package me.jerrywang.scala.study.algorithms.leetcode

// LC 21
object MergeTwoSortedLists {

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null) {
      l2
    } else if (l2 == null) {
      l1
    } else if (l1.value < l2.value) {
      l1.next = mergeTwoLists(l1.next, l2)
      l1
    } else {
      l2.next = mergeTwoLists(l1, l2.next)
      l2
    }
  }

  def main(args: Array[String]): Unit = {
    val l1 = ListNode(1, ListNode(2, ListNode(4, null)))
    val l2 = ListNode(1, ListNode(3, ListNode(4, null)))
    println(MergeTwoSortedLists.mergeTwoLists(l1, l2))
  }
}
