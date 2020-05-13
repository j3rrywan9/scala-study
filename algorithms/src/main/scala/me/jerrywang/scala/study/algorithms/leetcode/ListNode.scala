package me.jerrywang.scala.study.algorithms.leetcode

case class ListNode(var value: Int, var next: ListNode) {
  def this() = this(0, null)
  def this(value: Int) = this(value, null)
}
